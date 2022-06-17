package com.clonecodingproject.clone_coding_project_9_teams.controller;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Post;
import com.clonecodingproject.clone_coding_project_9_teams.dto.PostRequestDto;
import com.clonecodingproject.clone_coding_project_9_teams.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{postId}")
    public Post postDetail(@PathVariable Long postId) {
        return postService.postDetail(postId);
    }

    @PostMapping("/post")
    public void postSave(@RequestBody PostRequestDto postRequestDto) {
        postService.postSave(postRequestDto);
    }
}
