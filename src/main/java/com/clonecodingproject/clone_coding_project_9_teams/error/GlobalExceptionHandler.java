package com.clonecodingproject.clone_coding_project_9_teams.error;

import com.clonecodingproject.clone_coding_project_9_teams.error.exceptions.EmailDubplicateException;
import com.clonecodingproject.clone_coding_project_9_teams.error.exceptions.LoginException;
import com.clonecodingproject.clone_coding_project_9_teams.error.exceptions.NicknameDubplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmailDubplicateException.class)
    public ResponseEntity<ErrorResponse> handleEmailDubplicateException(EmailDubplicateException ex){
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }


    @ExceptionHandler(NicknameDubplicateException.class)
    public ResponseEntity<ErrorResponse> handleNicknameDupblicateException(NicknameDubplicateException ex){
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }


    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorResponse> handleLoginException(LoginException ex){
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }
}
