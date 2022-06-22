package com.clonecodingproject.clone_coding_project_9_teams.error.exceptions;

import com.clonecodingproject.clone_coding_project_9_teams.error.ErrorCode;
import lombok.Getter;

@Getter
public class EmailDubplicateException extends RuntimeException{

    private final ErrorCode errorCode;

    public EmailDubplicateException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
