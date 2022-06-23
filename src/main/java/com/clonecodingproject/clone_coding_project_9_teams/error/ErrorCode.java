package com.clonecodingproject.clone_coding_project_9_teams.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    LOGIN_EXCEPTION(401, "아이디 또는 비밀번호가 틀렸습니다."),
    EMAIL_DUBP_EXCEPTION(400, "이메일이 중복 되었습니다."),
    NICKNAME_DUBP_EXCEPTION(400, "닉네임이 중복 되었습니다.");


    private final int status;
    private final String message;
}
