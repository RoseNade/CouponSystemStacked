package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CustomerService {
    Coupon buyCoupon(int customerId, int couponId, UUID token) throws CustomExceptions;

    Set<Coupon> getAllCoupons(int customerId, UUID token) throws CustomExceptions;

    Set<Coupon> getAllCouponsByCategory(int customerId, Category category, UUID token) throws CustomExceptions;

    Set<Coupon> getAllCouponsByPrice(int customerId, double price, UUID token) throws CustomExceptions;

    Customer getDetails(int customerId, UUID token) throws CustomExceptions;

    List<Coupon> getAllCoupons(UUID token);

//    boolean login(String email, String password) throws CustomExceptions;
}
