package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;

import java.util.UUID;

public interface WelcomeService {
    void register(String email, String password, String name, ClientType clientType) throws Exception;

    UUID login(String email, String password, ClientType clientType) throws CouponSecurityExceptions;
}
