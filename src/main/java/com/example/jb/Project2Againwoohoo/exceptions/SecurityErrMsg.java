package com.example.jb.Project2Againwoohoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SecurityErrMsg {
    CREDENTIALS_WRONG("Email or password is wrong", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("Invalid token, no access", HttpStatus.UNAUTHORIZED),
    INVALID_CLIENT_TYPE("Invalid client type", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus httpStatus;
}
