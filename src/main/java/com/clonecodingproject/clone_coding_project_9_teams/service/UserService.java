package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.User;
import com.clonecodingproject.clone_coding_project_9_teams.dto.SignupDto;
import com.clonecodingproject.clone_coding_project_9_teams.dto.SignupResDto;
import com.clonecodingproject.clone_coding_project_9_teams.encoder.SHA256;
import com.clonecodingproject.clone_coding_project_9_teams.repository.UserRepository;
import com.clonecodingproject.clone_coding_project_9_teams.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    public SignupResDto signUp(SignupDto signupDto) throws NoSuchAlgorithmException {
        SignupResDto signupResDto = new SignupResDto();
        //입력 받은 값 체크
        userValidator.checkValues(signupDto);

        //등록된 유저 중 이메일 중복 체크
        if(userValidator.checkDupeEmail(signupDto)){
           signupResDto.setMessage("이메일이 중복 되었습니다.");

        //등록된 유저 중 닉네임 중복 체크
        }else if (userValidator.checkDupeNickname(signupDto)) {
            signupResDto.setMessage("닉네임이 중복 되었습니다.");

        //위의 모든 예외처리를 통과하면 모든 비밀번호 암호화 후 유저 등록
        }else{
            String encodedPw = SHA256.encrypt(signupDto.getPassword());
            User user = new User(signupDto, encodedPw);
            userRepository.save(user);
            signupResDto.setMessage("회원가입을 성공했습니다!");
        }
        return signupResDto;
    }
}
