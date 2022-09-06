package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    Coupon addCoupon(int companyId, Coupon coupon, UUID token) throws CustomExceptions;

    void deleteCoupon(int companyId, int couponID, UUID token) throws CustomExceptions;

    Coupon updateCoupon(int companyId, int couponID, Coupon coupon, UUID token) throws CustomExceptions;

    List<Coupon> getAllCoupons(int companyId, UUID token) throws CustomExceptions;

    List<Coupon> getAllCouponsByCategory(int companyId, Category category, UUID token);

    List<Coupon> getAllCouponsByPrice(int companyId, double price, UUID token);

    Company getDetails(int companyId, UUID token) throws CustomExceptions;

    Coupon getOneCoupon(int companyId, int couponID, UUID token) throws CustomExceptions;

//    boolean login(String email, String password) throws CustomExceptions;
}
