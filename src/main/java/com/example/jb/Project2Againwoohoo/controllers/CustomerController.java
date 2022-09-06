package com.example.jb.Project2Againwoohoo.controllers;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.security.TokenManager;
import com.example.jb.Project2Againwoohoo.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    private final CustomerService customerService;

    private final TokenManager tokenManager;

    @PostMapping("/coupons/{couponId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon buyCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return customerService.buyCoupon(tokenManager.getUserId(token), couponId, token);
    }

    @GetMapping("/coupons")
    public Set<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return customerService.getAllCoupons(tokenManager.getUserId(token), token);
    }

    @GetMapping("/coupons/category/{category}")
    public Set<Coupon> getAllCouponsByCategory(@PathVariable Category category , @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return customerService.getAllCouponsByCategory(tokenManager.getUserId(token), category, token);
    }

    @GetMapping("/coupons/price/{price}")
    public Set<Coupon> getAllCouponsByPrice(@PathVariable double price, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return customerService.getAllCouponsByPrice(tokenManager.getUserId(token), price, token);
    }

    @GetMapping("/details")
    public Customer getDetails(@RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return customerService.getDetails(tokenManager.getUserId(token), token);
    }

    @GetMapping("/allCoupons")
    public List<Coupon> getAllCompaniesCoupons(@RequestHeader("Authorization") UUID token){
        return customerService.getAllCoupons(token);
    }
}
