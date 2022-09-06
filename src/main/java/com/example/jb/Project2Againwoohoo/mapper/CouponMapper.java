package com.example.jb.Project2Againwoohoo.mapper;

import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.dto.CouponPayloadDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouponMapper implements Mapper<Coupon, CouponPayloadDto> {
    @Override
    public Coupon toDao(CouponPayloadDto couponPayloadDto) {
        return Coupon.builder()
                .category(couponPayloadDto.getCategory())
                .title(couponPayloadDto.getTitle())
                .description(couponPayloadDto.getDescription())
                .startDate(couponPayloadDto.getStartDate())
                .endDate(couponPayloadDto.getEndDate())
                .amount(couponPayloadDto.getAmount())
                .price(couponPayloadDto.getPrice())
                .image(couponPayloadDto.getImage())
                .build();
    }

    @Override
    public CouponPayloadDto toPayloadDTO(Coupon coupon) {
        return CouponPayloadDto.builder()
                .category(coupon.getCategory())
                .title(coupon.getTitle())
                .description(coupon.getDescription())
                .startDate(coupon.getStartDate())
                .endDate(coupon.getEndDate())
                .amount(coupon.getAmount())
                .price(coupon.getPrice())
                .image(coupon.getImage())
                .build();
    }

    @Override
    public List<Coupon> toDaoList(List<CouponPayloadDto> couponPayloadDtos) {
        return couponPayloadDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CouponPayloadDto> toPayloadDTOList(List<Coupon> coupons) {
        return coupons.stream().map(this::toPayloadDTO).collect(Collectors.toList());
    }
}
