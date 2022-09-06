package com.example.jb.Project2Againwoohoo.beans;

import com.example.jb.Project2Againwoohoo.dto.CouponPayloadDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Company company;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;

    private int amount;

    private double price;

    private String image;

    public Coupon(CouponPayloadDto couponPayloadDto){
        this.category = couponPayloadDto.getCategory();
        this.title = couponPayloadDto.getTitle();
        this.description = couponPayloadDto.getDescription();
        this.startDate = couponPayloadDto.getStartDate();
        this.endDate = couponPayloadDto.getEndDate();
        this.amount = couponPayloadDto.getAmount();
        this.price = couponPayloadDto.getPrice();
        this.image = couponPayloadDto.getImage();
    }

}
