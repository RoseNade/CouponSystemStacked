package com.example.jb.Project2Againwoohoo.dto;


import com.example.jb.Project2Againwoohoo.beans.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompanyDto  {

    private int id;

    private String name;

    private String email;

    private String password;

    private Set<Coupon> coupons;
}
