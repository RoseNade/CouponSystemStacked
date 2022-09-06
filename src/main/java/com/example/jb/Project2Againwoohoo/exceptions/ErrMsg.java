package com.example.jb.Project2Againwoohoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrMsg {
    NAME_ALREADY_EXISTS("Name already exists"),
    EMAIL_ALREADY_EXISTS("Email already exists"),
    COMPANY_NOT_EXIST("Company doesn't exist"),
    INCORRECT_LOGIN("Login credentials aren't right"),
    COUPON_NOT_EXIST("The coupon doesn't exist"),
    CUSTOMER_NOT_EXIST("Customer doesn't exist"),
    CUSTOMER_EMAIL_EXIST("Customer already exists"),
    COUPON_RAN_OUT("Out of coupons"),
    COUPON_EXPIRED("Coupon's date already expired"),
    COUPON_ALREADY_EXIST("Coupon with this title already exists"),
    CUSTOMER_OWNS_COUPON("Customer already owns this coupon");

    private final String message;
}
