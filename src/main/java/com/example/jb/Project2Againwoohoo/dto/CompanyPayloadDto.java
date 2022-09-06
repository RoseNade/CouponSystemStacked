package com.example.jb.Project2Againwoohoo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompanyPayloadDto {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

//    private List<Coupon> coupons;
}
