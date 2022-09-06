package com.example.jb.Project2Againwoohoo.controllers;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.dto.CouponPayloadDto;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.security.TokenManager;
import com.example.jb.Project2Againwoohoo.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController {
    private final CompanyService companyService;
    private final TokenManager tokenManager;

    @PostMapping("/coupons")
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon addCoupon(@RequestBody @Valid CouponPayloadDto couponPayloadDto, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return companyService.addCoupon(tokenManager.getUserId(token), new Coupon(couponPayloadDto), token);
    }

    @DeleteMapping("/coupons/{couponId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        companyService.deleteCoupon(tokenManager.getUserId(token), couponId, token);
    }

    @PutMapping("/coupons/{couponId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Coupon updateCoupon(@PathVariable int couponId, @RequestBody @Valid CouponPayloadDto couponPayloadDto, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return companyService.updateCoupon(tokenManager.getUserId(token), couponId, new Coupon(couponPayloadDto), token);
    }

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return companyService.getAllCoupons(tokenManager.getUserId(token), token);
    }

    @GetMapping("/coupons/{couponId}")
    public Coupon getOneCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return companyService.getOneCoupon(tokenManager.getUserId(token), couponId, token);
    }

    @GetMapping("/coupons/category/{category}")
    public List<Coupon> getAllCouponsByCategory(@PathVariable Category category, @RequestHeader("Authorization") UUID token) throws CouponSecurityExceptions {

        return companyService.getAllCouponsByCategory(tokenManager.getUserId(token), category, token);
    }

    @GetMapping("/coupons/price/{price}")
    public List<Coupon> getAllCouponsBelowPrice(@PathVariable double price, @RequestHeader("Authorization") UUID token) throws CouponSecurityExceptions {
        return companyService.getAllCouponsByPrice(tokenManager.getUserId(token), price, token);
    }

    @GetMapping("/details")
    public Company getDetails(@RequestHeader("Authorization") UUID token) throws CustomExceptions, CouponSecurityExceptions {
        return companyService.getDetails(tokenManager.getUserId(token), token);
    }
}
