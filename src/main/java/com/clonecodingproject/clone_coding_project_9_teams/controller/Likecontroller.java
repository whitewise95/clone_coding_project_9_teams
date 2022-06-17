package com.clonecodingproject.clone_coding_project_9_teams.controller;


import com.clonecodingproject.clone_coding_project_9_teams.dto.LikeDto;
import com.clonecodingproject.clone_coding_project_9_teams.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/like/{postId}")
public class Likecontroller {

    private final LikeService likeService;

    @PostMapping
    public void uplike(HttpServletRequest httpServletRequest,
                       @PathVariable Long postId){
        유저토큰 토큰 = (유저토큰) httpServletRequest.getAttribute("decode");
        LikeService.uplike(토큰, postId);
    }
}
