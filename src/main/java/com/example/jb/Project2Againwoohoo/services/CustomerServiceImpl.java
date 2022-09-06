package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CustomerServiceImpl extends ClientManager implements CustomerService {

    @Override
    public Coupon buyCoupon(int customerId, int couponId, UUID token) throws CustomExceptions {
        if(!couponRepo.existsById(couponId)){
            throw new CustomExceptions(ErrMsg.COUPON_NOT_EXIST);
        }

        Coupon coupon = couponRepo.getReferenceById(couponId);
//        if(!couponRepo.existsById(coupon.getId())){
//            throw new CustomExceptions(ErrMsg.COUPON_NOT_EXIST);
//        }

        if (coupon.getAmount() < 1) {
            throw new CustomExceptions(ErrMsg.COUPON_RAN_OUT);
        }

        if (coupon.getEndDate().toLocalDate().isBefore(LocalDate.now())) {
            throw new CustomExceptions(ErrMsg.COUPON_EXPIRED);
        }

        if(customerRepo.isCouponOwnedByCustomer(customerId, couponId).intValue() == 1){
            throw new CustomExceptions(ErrMsg.CUSTOMER_OWNS_COUPON);
        }

        customerRepo.buyCoupon(customerId, coupon.getId());
        coupon.setAmount(coupon.getAmount() - 1);
        return couponRepo.saveAndFlush(coupon);
    }

    @Override
    public Set<Coupon> getAllCoupons(int customerId, UUID token) throws CustomExceptions {
        return customerRepo.findById(customerId).orElseThrow(() -> new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST)).getCoupons();
    }

    @Override
    public Set<Coupon> getAllCouponsByCategory(int customerId, Category category, UUID token) throws CustomExceptions {
        Set<Coupon> coupons = customerRepo.findById(customerId).orElseThrow(() -> new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST)).getCoupons();

        for (Coupon coupon : coupons) {
            if(coupon.getCategory() == category){
                coupons.add(coupon);
            }
        }

        return coupons;

    }

    @Override
    public Set<Coupon> getAllCouponsByPrice(int customerId, double price, UUID token) throws CustomExceptions {
        Set<Coupon> coupons = customerRepo.findById(customerId).orElseThrow(() -> new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST)).getCoupons();

        for (Coupon coupon : coupons) {
            if (coupon.getPrice() < price) {
                coupons.add(coupon);
            }
        }

        return coupons;
    }

    @Override
    public Customer getDetails(int customerId, UUID token) throws CustomExceptions {
        return customerRepo.findById(customerId).orElseThrow(() -> new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST));
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token) {
        return couponRepo.findAll();
    }
}
