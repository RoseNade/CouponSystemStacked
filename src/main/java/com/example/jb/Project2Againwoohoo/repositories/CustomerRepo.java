package com.example.jb.Project2Againwoohoo.repositories;

import com.example.jb.Project2Againwoohoo.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);

    boolean existsByPassword(String password);

    Customer findByEmail(String email);

    @Query(value = "INSERT INTO `couponsystem2`.`customers_coupons` (`customer_id`, `coupon_id`) VALUES (?, ?);", nativeQuery = true)
    @Modifying
    @Transactional
    void buyCoupon(int customerID, int couponID);

    @Query(value = "select exists(SELECT * FROM couponsystem2.customers_coupons where customer_id = ? and coupon_id = ?) as res;", nativeQuery = true)
    BigInteger isCouponOwnedByCustomer(int customerID, int couponID);

    boolean existsByEmailAndPassword(String email, String password);

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
