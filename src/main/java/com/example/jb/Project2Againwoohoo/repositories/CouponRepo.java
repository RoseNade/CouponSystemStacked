package com.example.jb.Project2Againwoohoo.repositories;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {
    boolean existsByTitleAndCompanyId(String title, int id);

    @Query(value = "DELETE FROM couponsystem2.coupons where end_date < curdate() and id <> 0;", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteExpiredCoupons();

    List<Coupon> findAllByCompanyIdAndCategory(int id, Category category);

    List<Coupon> findAllByCompanyIdAndPriceLessThan(int id, double price);

    @Query(value ="delete from couponsystem2.customers_coupons where coupon_id = ?;", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCouponsFromCustomers(int couponId);

    List<Coupon> findByCompanyId(int companyId);
}
