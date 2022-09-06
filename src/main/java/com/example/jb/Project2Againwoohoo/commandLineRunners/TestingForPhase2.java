//package com.example.jb.Project2Againwoohoo.commandLineRunners;
//
//import com.example.jb.Project2Againwoohoo.beans.*;
//import com.example.jb.Project2Againwoohoo.repositories.CompanyRepo;
//import com.example.jb.Project2Againwoohoo.security.LoginManager;
//import com.example.jb.Project2Againwoohoo.services.AdminService;
//import com.example.jb.Project2Againwoohoo.services.CompanyService;
//import com.example.jb.Project2Againwoohoo.services.CompanyServiceImpl;
//import com.example.jb.Project2Againwoohoo.services.CustomerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//@Component
//@RequiredArgsConstructor
//public class CLR implements CommandLineRunner {
//
////    private final CompanyRepo companyRepo;
//
//    @Autowired
//    private LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Date today = Date.valueOf(LocalDate.now());
//        Date inAWeek = Date.valueOf(LocalDate.now().plusDays(7));
//        Date yesterday = Date.valueOf(LocalDate.now().minusDays(1));
//        Date twoDaysAgo = Date.valueOf(LocalDate.now().minusDays(2));
//
//        Customer customer1 = Customer.builder()
//                .email("customer1@gmail.com")
//                .password("123")
//                .firstName("customer1")
//                .lastName("customer1")
//                .build();
//
//        Customer customer2 = Customer.builder()
//                .email("customer2@gmail.com")
//                .password("123")
//                .firstName("customer2")
//                .lastName("customer2")
//                .build();
//
//        Customer customer3 = Customer.builder()
//                .email("customer3@gmail.com")
//                .password("123")
//                .firstName("customer3")
//                .lastName("customer3")
//                .build();
//
//        Customer customer4 = Customer.builder()
//                .email("customer4@gmail.com")
//                .password("123")
//                .firstName("customer4")
//                .lastName("customer4")
//                .build();
//
//        Customer customer5 = Customer.builder()
//                .email("customer5@gmail.com")
//                .password("123")
//                .firstName("customer5")
//                .lastName("customer5")
//                .build();
//
//        Coupon coupon1 = Coupon.builder()
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
//        Coupon coupon2 = Coupon.builder()
//                .amount(5)
//                .title("Steak")
//                .category(Category.FOOD)
//                .image("URL")
//                .price(40)
//                .description("Vintage Food!")
//                .startDate(today)
//                .endDate(inAWeek)
//                .build();
//
//        Coupon coupon3 = Coupon.builder()
//                .amount(3)
//                .title("Candy")
//                .category(Category.FOOD)
//                .image("URL")
//                .price(10)
//                .description("Delicious pop candy")
//                .startDate(today)
//                .endDate(inAWeek)
//                .build();
//
//        Coupon coupon4 = Coupon.builder()
//                .amount(0)
//                .title("HOLLYWOOD")
//                .category(Category.VACATION)
//                .image("URL")
//                .price(900)
//                .description("Meet all your favourite models from Hollywood")
//                .startDate(twoDaysAgo)
//                .endDate(yesterday)
//                .build();
//
//        Coupon coupon5 = Coupon.builder()
//                .amount(8)
//                .title("Makeup")
//                .category(Category.ACCESSORIES)
//                .image("URL")
//                .price(25)
//                .description("Concealer")
//                .startDate(today)
//                .endDate(inAWeek)
//                .build();
//
//        Company company1 = Company.builder()
//                .name("company1")
//                .email("company1@gmail.com")
//                .password("123")
//                .build();
//
//        Company company2 = Company.builder()
//                .name("company2")
//                .email("company2@gmail.com")
//                .password("123")
//                .build();
//
//        Company company3 = Company.builder()
//                .name("company3")
//                .email("company3@gmail.com")
//                .password("123")
//                .build();
//
//        Company company4 = Company.builder()
//                .name("company4")
//                .email("company4@gmail.com")
//                .password("123")
//                .build();
//
//        Company company5 = Company.builder()
//                .name("company5")
//                .email("company5@gmail.com")
//                .password("123")
//                .build();
//
//        // ADMIN FUNCTIONS
//        // BENEATH ARE ADMIN FUNCTIONS FOR CUSTOMERS
//        System.out.println("Login as admin");
//        System.out.println("---------------------------------------------------------------------------------------");
//        AdminService admin = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.ADMIN);
//
////        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Adding Customers");
//        admin.addCustomer(customer1);
//        admin.addCustomer(customer2);
//        admin.addCustomer(customer3);
//        admin.addCustomer(customer4);
//        admin.addCustomer(customer5);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Deleting customers");
//        admin.deleteCustomer(5);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Updating customers");
//        customer4.setFirstName("Jake");
//        admin.updateCustomer(4, customer4);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all customers");
//        admin.getAllCustomers().forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get one customer");
//        System.out.println(admin.getOneCustomer(2));
//
//        // BELOW ARE ADMIN FUNCTIONS FOR COMPANIES
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Adding companies");
//        admin.addCompany(company1);
//        admin.addCompany(company2);
//        admin.addCompany(company3);
//        admin.addCompany(company4);
//        admin.addCompany(company5);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Update companies");
//        company4.setName("updated company");
//        admin.updateCompany(4, company4);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Deleting companies");
//        admin.deleteCompany(5);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all companies");
//        admin.getAllCompanies().forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get one company");
//        System.out.println(admin.getOneCompany(3));
//
//
//        // BENEATH ARE FUNCTIONS BY COMPANIES
//
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Login as companies");
//        CompanyService company1Login = (CompanyService) loginManager.login("company1@gmail.com", "123", ClientType.COMPANY);
//        CompanyService company2Login = (CompanyService) loginManager.login("company2@gmail.com", "123", ClientType.COMPANY);
//        CompanyService company3Login = (CompanyService) loginManager.login("company3@gmail.com", "123", ClientType.COMPANY);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Adding coupons to companies");
//        company1Login.addCoupon(coupon1);
//        company1Login.addCoupon(coupon4);
//        company1Login.addCoupon(coupon5);
//        company2Login.addCoupon(coupon2);
//        company3Login.addCoupon(coupon3);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Delete coupons from companies");
//        company1Login.deleteCoupon(5);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Updating coupons");
//        coupon1.setDescription("new description!");
//        company1Login.updateCoupon(1, coupon1);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons by company1");
//        company1Login.getAllCoupons().forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons by company1 by category ELECTRICITY");
//        company1Login.getAllCouponsByCategory(Category.ELECTRICITY).forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons under price 40");
//        company1Login.getAllCouponsByPrice(30).forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get one coupon");
//        System.out.println(company1Login.getOneCoupon(1));
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get company details");
//        System.out.println(company1Login.getDetails());
//
//
//        // BENEATH ARE FUNCTIONS BY CUSTOMERS
//
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Login as customers");
//        CustomerService customer1Login = (CustomerService) loginManager.login("customer1@gmail.com", "123", ClientType.CUSTOMER);
//        CustomerService customer2Login = (CustomerService) loginManager.login("customer2@gmail.com", "123", ClientType.CUSTOMER);
//        CustomerService customer3Login = (CustomerService) loginManager.login("customer3@gmail.com", "123", ClientType.CUSTOMER);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Buy coupons");
//        try{
//            customer1Login.buyCoupon(coupon1);
//            customer1Login.buyCoupon(coupon5);
//            customer2Login.buyCoupon(coupon2);
//            customer3Login.buyCoupon(coupon3);
//            customer1Login.buyCoupon(coupon1);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons by customer1");
//        customer1Login.getAllCoupons().forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons by customer1 by category ELECTRICITY");
//        customer1Login.getAllCouponsByCategory(Category.ELECTRICITY).forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get all coupons by customer1 by price 30");
//        customer1Login.getAllCouponsByPrice(30).forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("Get customer3 details");
//        System.out.println(customer3Login.getDetails());
//    }
//}
