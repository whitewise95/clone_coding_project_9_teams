package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.*;
import com.clonecodingproject.clone_coding_project_9_teams.dto.PostRequestDto;
import com.clonecodingproject.clone_coding_project_9_teams.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                                userRepository.save(new User("test","test","test","test")) // 나중엔 토큰으로 변경
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
}
