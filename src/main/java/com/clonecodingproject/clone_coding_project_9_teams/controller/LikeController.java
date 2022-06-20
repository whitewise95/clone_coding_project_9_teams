package com.clonecodingproject.clone_coding_project_9_teams.controller;


import com.clonecodingproject.clone_coding_project_9_teams.jwt.UserInfoInJwt;
import com.clonecodingproject.clone_coding_project_9_teams.repository.UserRepository;
import com.clonecodingproject.clone_coding_project_9_teams.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;
    private final UserInfoInJwt userInfoInJwt;

    @PostMapping("/like/{postId}")
    public void uplike(HttpServletRequest httpServletRequest,
                       @PathVariable Long postId) {
        String email = userInfoInJwt.getEmail_InJWT(httpServletRequest.getHeader("Authorization"));
        likeService.uplike(postId, email);
    }

    @GetMapping("/like/{postId}")
    public boolean checkLike(HttpServletRequest httpServletRequest,
                             @PathVariable Long postId){
        String email = userInfoInJwt.getEmail_InJWT(httpServletRequest.getHeader("Authorization"));
        return likeService.checkLike(postId, email);
    }

}
