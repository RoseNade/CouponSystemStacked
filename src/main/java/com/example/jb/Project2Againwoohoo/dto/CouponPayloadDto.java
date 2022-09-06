package com.example.jb.Project2Againwoohoo.dto;

import com.example.jb.Project2Againwoohoo.beans.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponPayloadDto {
//    private Company company;

    @Enumerated(EnumType.STRING)
//    @NotBlank
    private Category category;

    @NotBlank
    private String title;

//    private int companyId;

    @NotBlank
    private String description;


    private Date startDate;

    private Date endDate;

    private int amount;

    private double price;

    @NotBlank
    private String image;
}
