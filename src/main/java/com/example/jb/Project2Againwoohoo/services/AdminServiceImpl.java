package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Coupon;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl extends ClientManager implements AdminService {

    @Override
    public Customer addCustomer(Customer customer, UUID token) throws CustomExceptions {
        if(customerRepo.existsByEmail(customer.getEmail())){
            throw new CustomExceptions(ErrMsg.CUSTOMER_EMAIL_EXIST);
        }
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int customerID, UUID token) throws CustomExceptions {
        if(!customerRepo.existsById(customerID)){
            throw new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST);
        }
        customerRepo.deleteById(customerID);
    }

    @Override
    public Customer updateCustomer(int customerID, Customer customer, UUID token) throws CustomExceptions {
        if(!customerRepo.existsById(customerID)){
            throw new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST);
        }

        customer.setId(customerID);
        return customerRepo.saveAndFlush(customer);
    }

    @Override
    public List<Customer> getAllCustomers(UUID token) {
        return customerRepo.findAll();
    }

    @Override
    public Customer getOneCustomer(int customerID, UUID token) throws CustomExceptions {
        return customerRepo.findById(customerID).orElseThrow(() -> new CustomExceptions(ErrMsg.CUSTOMER_NOT_EXIST));
    }

//    @Override
//    public boolean login(String email, String password) {
//        return email.equals("admin@admin.com") && password.equals("admin");
//    }

    @Override
    public Company addCompany(Company company, UUID token) throws CustomExceptions {
        if (companyRepo.existsByName(company.getName())) {
            throw new CustomExceptions(ErrMsg.NAME_ALREADY_EXISTS);
        }

        if(companyRepo.existsByEmail(company.getEmail())){
            throw new CustomExceptions(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        return companyRepo.save(company);
    }

    @Override
    public Company updateCompany(int companyID, Company company, UUID token) throws CustomExceptions {
        if (!companyRepo.existsById(companyID)) {
            throw new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST);
        }

        Company tmp = companyRepo.getReferenceById(companyID);
        company.setName(tmp.getName());
        company.setId(companyID);

        return companyRepo.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyID, UUID token) throws CustomExceptions {
        if (!companyRepo.existsById(companyID)) {
            throw new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST);
        }

        Company company = companyRepo.getReferenceById(companyID);
        for (Coupon coupon : company.getCoupons()) {
            couponRepo.delete(coupon);
            couponRepo.deleteCouponsFromCustomers(coupon.getId());
        }
        companyRepo.deleteById(companyID);
    }

    @Override
    public List<Company> getAllCompanies(UUID token) {
        return companyRepo.findAll();
    }

    @Override
    public Company getOneCompany(int companyID, UUID token) throws CustomExceptions {
        return companyRepo.findById(companyID).orElseThrow(() -> new CustomExceptions(ErrMsg.COMPANY_NOT_EXIST));
    }
}
