package com.example.jb.Project2Againwoohoo.exceptions;

import lombok.Data;

@Data
public class CouponSecurityExceptions extends Exception{
    private SecurityErrMsg securityErrMsg;

    public CouponSecurityExceptions(SecurityErrMsg message) {
        super(message.getMessage());
        this.securityErrMsg = message;
    }
}
