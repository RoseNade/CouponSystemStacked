package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.repositories.CompanyRepo;
import com.example.jb.Project2Againwoohoo.repositories.CouponRepo;
import com.example.jb.Project2Againwoohoo.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientManager {
    @Autowired
    protected CompanyRepo companyRepo;
    @Autowired
    protected CustomerRepo customerRepo;
    @Autowired
    protected CouponRepo couponRepo;


//    protected abstract boolean login(String email, String password) throws CustomExceptions;
}
