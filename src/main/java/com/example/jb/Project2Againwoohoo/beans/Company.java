package com.example.jb.Project2Againwoohoo.beans;

import com.example.jb.Project2Againwoohoo.dto.CompanyPayloadDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "company"/*, orphanRemoval = true*/)
    @Singular
    @ToString.Exclude
    @JsonManagedReference
    private List<Coupon> coupons;

    public Company(CompanyPayloadDto companyPayloadDto) {
        this.name = companyPayloadDto.getName();
        this.email = companyPayloadDto.getEmail();
        this.password = companyPayloadDto.getPassword();
//        this.coupons = companyPayloadDto.getCoupons();
    }
}
