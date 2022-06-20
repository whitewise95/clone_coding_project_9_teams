package com.clonecodingproject.clone_coding_project_9_teams.controller;


import com.clonecodingproject.clone_coding_project_9_teams.domain.Users;
import com.clonecodingproject.clone_coding_project_9_teams.repository.UserRepository;
import com.clonecodingproject.clone_coding_project_9_teams.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;
    private final UserRepository userRepository;

    @PostMapping("/like/{postId}")
    public void uplike(//HttpServletRequest httpServletRequest,
                       @PathVariable Long postId) {
//        유저토큰 토큰 = (유저토큰) httpServletRequest.getAttribute("토큰");
        likeService.uplike(postId);
    }

    @GetMapping("/like/{postId}")
    public boolean checkLike( //HttpServletRequest httpServletRequest,
                             @PathVariable Long postId){
//        유저토큰 토큰 = (유저토큰) httpServletRequest.getAttribute("토큰");
        return likeService.checkLike( postId);
    }

}
