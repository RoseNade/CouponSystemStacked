package com.example.jb.Project2Againwoohoo.dto;


import com.example.jb.Project2Againwoohoo.beans.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CouponDto {
    private int id;

    private int company_id;

    private Category category;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;

    private int amount;

    private double price;

    private String image;
}
