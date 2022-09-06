package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl extends ClientManager implements CompanyService {

//    @Override
//    public boolean login(String email, String password) throws CustomExceptions {
////        if (companyRepo.existsByEmail(email) && companyRepo.existsByPassword(password)) {
////            company = companyRepo.findByEmail(email);
////            return true;
////        }
////        throw new CustomExceptions(ErrMsg.INCORRECT_LOGIN);
//        return false;
//    }

    @Override
    public Coupon addCoupon(int companyId, Coupon coupon, UUID token) throws CustomExceptions {
        if(couponRepo.existsByTitleAndCompanyId(coupon.getTitle(), companyId)){
            throw new CustomExceptions(ErrMsg.COUPON_ALREADY_EXIST);
        }

        Company company = companyRepo.findById(companyId).orElseThrow(() -> new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST));

        coupon.setCompany(company);
        return couponRepo.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int companyId, int couponID, UUID token) throws CustomExceptions {
        if (!couponRepo.existsById(couponID)) {
            throw new CustomExceptions(ErrMsg.COUPON_NOT_EXIST);
        }

        couponRepo.deleteById(couponID);
        couponRepo.deleteCouponsFromCustomers(couponID);
    }

    @Override
    public Coupon updateCoupon(int companyId, int couponId, Coupon coupon, UUID token) throws CustomExceptions {
        Company company = companyRepo.findById(companyId).orElseThrow(() -> new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST));
        if(!couponRepo.existsById(couponId)){
            throw new CustomExceptions(ErrMsg.COUPON_NOT_EXIST);
        }
        coupon.setId(couponId);
        coupon.setCompany(company);
        return couponRepo.saveAndFlush(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons(int companyId, UUID token) throws CustomExceptions {
        return couponRepo.findByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getAllCouponsByCategory(int companyId, Category category, UUID token) {
        return couponRepo.findAllByCompanyIdAndCategory(companyId, category);
    }

    @Override
    public List<Coupon> getAllCouponsByPrice(int companyId, double price, UUID token) {
        return couponRepo.findAllByCompanyIdAndPriceLessThan(companyId, price);
    }

    @Override
    public Company getDetails(int companyId, UUID token) throws CustomExceptions {
        return companyRepo.findById(companyId).orElseThrow(() -> new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST));
    }

    @Override
    public Coupon getOneCoupon(int companyId, int couponID, UUID token) throws CustomExceptions {
        return couponRepo.findById(couponID).orElseThrow(() -> new CustomExceptions(ErrMsg.COUPON_NOT_EXIST));
    }
}
