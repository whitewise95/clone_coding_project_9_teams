package com.clonecodingproject.clone_coding_project_9_teams.controller;

import com.clonecodingproject.clone_coding_project_9_teams.dto.SignupDto;
import com.clonecodingproject.clone_coding_project_9_teams.dto.SignupResDto;
import com.clonecodingproject.clone_coding_project_9_teams.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public SignupResDto signUp(@RequestBody SignupDto signupDto) throws NoSuchAlgorithmException {
        return userService.signUp(signupDto);
    }
}
