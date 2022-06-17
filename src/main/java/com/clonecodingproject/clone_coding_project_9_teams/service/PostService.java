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

    public Post postDetail(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 글을 찾지 못했습니다."));
    }

    @Transactional
    public void postSave(PostRequestDto postRequestDto) {
        List<ImageUrl> imageUrls = imageService.imageSave(postRequestDto.getImageUrl()); //이미지 저장
        imageService.updateToPost(
                imageUrls,
                postRepository.save(
                        new Post(
                                postRequestDto,
                                imageUrls,
                                userRepository.save(new User("test","test","test","test")) // 나중엔 토큰으로 변경
                        )
                )//글 저장
        ); // 이미지 postId update;
    }
}
