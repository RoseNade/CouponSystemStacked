package com.example.jb.Project2Againwoohoo.commandLineRunners;

import com.example.jb.Project2Againwoohoo.beans.Category;
import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.controllers.CompanyController;
import com.example.jb.Project2Againwoohoo.repositories.CompanyRepo;
import com.example.jb.Project2Againwoohoo.repositories.CouponRepo;
import com.example.jb.Project2Againwoohoo.repositories.CustomerRepo;
import com.example.jb.Project2Againwoohoo.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestingShit implements CommandLineRunner {
    private final CompanyController companyController;
    private final CompanyService companyService;
    private final CompanyRepo companyRepo;
    private final CustomerRepo customerRepo;
    private final CouponRepo couponRepo;

    @Override
    public void run(String... args) throws Exception {
        Date today = Date.valueOf(LocalDate.now());
        Date inAWeek = Date.valueOf(LocalDate.now().plusDays(7));
        Date yesterday = Date.valueOf(LocalDate.now().minusDays(1));
        Date twoDaysAgo = Date.valueOf(LocalDate.now().minusDays(2));

        Customer customer1 = Customer.builder()
                .email("customer1@gmail.com")
                .password("123")
                .firstName("customer1")
                .lastName("customer1")
                .build();

        Customer customer2 = Customer.builder()
                .email("customer2@gmail.com")
                .password("123")
                .firstName("customer2")
                .lastName("customer2")
                .build();

        Customer customer3 = Customer.builder()
                .email("customer3@gmail.com")
                .password("123")
                .firstName("customer3")
                .lastName("customer3")
                .build();

        Customer customer4 = Customer.builder()
                .email("customer4@gmail.com")
                .password("123")
                .firstName("customer4")
                .lastName("customer4")
                .build();

        Customer customer5 = Customer.builder()
                .email("customer5@gmail.com")
                .password("123")
                .firstName("customer5")
                .lastName("customer5")
                .build();

        Coupon coupon1 = Coupon.builder()
                .amount(12)
                .title("MONITORS")
                .category(Category.ELECTRICITY)
                .image("URL")
                .price(150)
                .description("24 inch HD 4k monitor")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon2 = Coupon.builder()
                .amount(650)
                .title("TRIP AROUND THE WORLD")
                .category(Category.VACATION)
                .image("URL")
                .price(5)
                .description("Vegas baby")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon3 = Coupon.builder()
                .amount(9)
                .title("MAKEUP")
                .category(Category.ACCESSORIES)
                .image("URL")
                .price(40)
                .description("Eyeliner")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon4 = Coupon.builder()
                .amount(22)
                .title("FISH")
                .category(Category.FOOD)
                .image("URL")
                .price(42)
                .description("Salmon")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon5 = Coupon.builder()
                .amount(13)
                .title("MEAT")
                .category(Category.FOOD)
                .image("URL")
                .price(50)
                .description("STEAK")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon6 = Coupon.builder()
                .amount(22)
                .title("TIRES")
                .category(Category.VEHICLES)
                .image("URL")
                .price(139)
                .description("Anti-slip tires")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon7 = Coupon.builder()
                .amount(22)
                .title("PC PARTS")
                .category(Category.ELECTRICITY)
                .image("URL")
                .price(1200)
                .description("Rtx 3070 super")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Coupon coupon8 = Coupon.builder()
                .amount(4)
                .title("Jelly")
                .category(Category.FOOD)
                .image("URL")
                .price(22)
                .description("Delicious strawberry jelly")
                .startDate(today)
                .endDate(inAWeek)
                .build();

        Company company1 = Company.builder()
                .name("company1")
                .email("company1@gmail.com")
                .password("123")
                .build();

        Company company2 = Company.builder()
                .name("company2")
                .email("company2@gmail.com")
                .password("123")
                .build();

        Company company3 = Company.builder()
                .name("company3")
                .email("company3@gmail.com")
                .password("123")
                .build();

        Company company4 = Company.builder()
                .name("company4")
                .email("company4@gmail.com")
                .password("123")
                .build();

        Company company5 = Company.builder()
                .name("company5")
                .email("company5@gmail.com")
                .password("123")
                .build();



        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
        customerRepo.save(customer4);
        customerRepo.save(customer5);

        companyRepo.save(company1);
        companyRepo.save(company2);
        companyRepo.save(company3);
        companyRepo.save(company4);
        companyRepo.save(company5);

        companyService.addCoupon(1, coupon1, null);
        companyService.addCoupon(1, coupon2, null);
        companyService.addCoupon(1, coupon3, null);
        companyService.addCoupon(1, coupon4, null);
        companyService.addCoupon(2, coupon5, null);
        companyService.addCoupon(3, coupon6, null);
        companyService.addCoupon(4, coupon7, null);
        companyService.addCoupon(5, coupon8, null);



//        CouponPayloadDto coupon1 = CouponPayloadDto.builder()
//                .amount(4)
//                .title("HDMI Cable")
//                .category(Category.ELECTRICITY)
//                .image("URL")
//                .price(5)
//                .description("Long cable for multiple use")
//                .startDate(today)
//                .endDate(inAWeek)
//                .build();
//
//        CompanyPayloadDto company1 = CompanyPayloadDto.builder()
//                .name("company1")
//                .email("company1@gmail.com")
//                .password("123")
//                .build();
//
//        CustomerPayloadDto customer1 = CustomerPayloadDto.builder()
//                .email("customer1@gmail.com")
//                .password("123")
//                .firstName("customer1")
//                .lastName("customer1")
//                .build();

//        customerRepo.save(customer1);
//        couponRepo.save(coupon1);
//        companyRepo.save(company1);

//        adminController.addCompany(company1);
//        companyController.addCoupon(1, coupon1);
//        adminController.addCustomer(customer1);

//        customerController.buyCoupon(1, 1);

//        companyController.deleteCoupon(1,1);


//        customerController.getAllCouponsByCategory(1, Category.ELECTRICITY).forEach(System.out::println);
    }
}
