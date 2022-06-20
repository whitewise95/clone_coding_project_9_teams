package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.*;
import com.clonecodingproject.clone_coding_project_9_teams.dto.PostRequestDto;
import com.clonecodingproject.clone_coding_project_9_teams.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ImageService imageService;

    //test
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Post postDetail(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 글을 찾지 못했습니다."));
    }

    @Transactional
    public void postSave(PostRequestDto postRequestDto) {
        List<ImageUrl> imageUrls = imageService.imageSave(postRequestDto.getImageUrl()); //이미지 저장

        imageService.imageUpdateToPost(   // 이미지 postId update;
                imageUrls,
                postRepository.save(  //글 저장
                        new Post(
                                postRequestDto,
                                imageUrls,
                                userRepository.save(new User("test")) // 나중엔 토큰으로 변경
                        )
                )
        );
    }

    @Transactional
    public void postUpdate(Long postId, PostRequestDto postRequestDto) {
        Post post = postDetail(postId); // 포스트 업데이트

        List<ImageUrl> imageUrls = imageService.ImageOverallPatch(  // 이미지 업데이트
                postId,
                postRequestDto.getImageUrl()
        );

        post.update(   //글 업데이터
                postRequestDto,
                imageUrls
        );

        imageService.imageUpdateToPost(  //이미지 연관관계 유지
                imageUrls,
                post
        );
    }

    @Transactional
    public void upView(Long postId, HttpSession httpSession){
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        String id = Long.toString(postId);
        String newId = "["+id+"]";

        String currentView = (String) httpSession.getAttribute("viewList");
//        System.out.println(currentView);


        if (currentView == null ){
            
            httpSession.setAttribute("viewList", newId);
            int count = postRepository.findById(postId).get().getViewCount()+1;
            post.setViewCount(count);
            postRepository.save(post);
        } else if (!currentView.contains( "["+id+"]")){

            String newList =newId+currentView;

            httpSession.setAttribute("viewList", newList);
            int count = postRepository.findById(postId).get().getViewCount()+1;
            post.setViewCount(count);
            postRepository.save(post);
        }
        System.out.println(currentView);
    }
    @Transactional
    public Slice<Post> getTopPost(Long page){
        PageRequest pageRequest = PageRequest.of(Math.toIntExact(page), 5, Sort.by(Sort.Direction.DESC,"viewCount"));
        return postRepository.findAllByOrderByLikeCountDesc(pageRequest);
    }

    @Transactional
    public Slice<Post> getAllPost(Long page){

        PageRequest pageRequest = PageRequest.of(Math.toIntExact(page), 5, Sort.by(Sort.Direction.DESC,"createdAt"));
        return postRepository.findAll(pageRequest);
    }

    @Transactional
    public Slice<Post> getRegionPost(Long page, String region){
        PageRequest pageRequest = PageRequest.of(Math.toIntExact(page), 5, Sort.by(Sort.Direction.DESC,"createdAt"));
        return postRepository.findAllByRegion(pageRequest, region);
    }

    @Transactional
    public Slice<Post> getTopRegionPost(Long page, String region){
        PageRequest pageRequest = PageRequest.of(Math.toIntExact(page), 5, Sort.by(Sort.Direction.DESC,"viewCount"));
        return postRepository.findAllByRegionOrderByLikeCountDesc(pageRequest, region);
    }

}