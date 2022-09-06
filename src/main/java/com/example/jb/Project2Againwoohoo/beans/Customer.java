package com.example.jb.Project2Againwoohoo.beans;

import com.example.jb.Project2Againwoohoo.dto.CustomerPayloadDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coupons")
    @JoinTable(name = "customers_coupons", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    @Singular
    private Set<Coupon> coupons = new HashSet<>();

    public Customer(CustomerPayloadDto customerPayloadDto) {
        this.firstName = customerPayloadDto.getFirstName();
        this.lastName = customerPayloadDto.getLastName();
        this.email = customerPayloadDto.getEmail();
        this.password = customerPayloadDto.getPassword();
//        this.coupons = customerPayloadDto.getCoupons();
    }
}