package com.clonecodingproject.clone_coding_project_9_teams.service.user;

import com.clonecodingproject.clone_coding_project_9_teams.domain.User;
import com.clonecodingproject.clone_coding_project_9_teams.dto.LoginDto;
import com.clonecodingproject.clone_coding_project_9_teams.dto.LoginResDto;
import com.clonecodingproject.clone_coding_project_9_teams.jwt.encoder.SHA256;
import com.clonecodingproject.clone_coding_project_9_teams.jwt.JwtTokenProvider;
import com.clonecodingproject.clone_coding_project_9_teams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {


    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    public LoginResDto login(LoginDto loginDto) throws NoSuchAlgorithmException {

        //로그인 정보에 맞는 유저 찾기
        Optional<User> user = userRepository.findByUsernameAndPassword(loginDto.getUsername(), SHA256.encrypt(loginDto.getPassword()));

        //아이디 비번 틀렸을 시
        if(!user.isPresent()){
            return LoginResDto.builder()
                    .errorMessage("아이디 또는 비밀번호가 틀렸습니다.")
                    .build();
        }

        String accessToken = jwtTokenProvider.createAccessToken(user.get().getUsername());
        return LoginResDto.builder()
                .accessToken(accessToken)
                .nickname(user.get().getNickname())
                .region(user.get().getRegion())
                .build();
    }
}
