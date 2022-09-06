package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    Company addCompany(Company company, UUID token) throws CustomExceptions;

    Company updateCompany(int companyID, Company company, UUID token) throws CustomExceptions;

    void deleteCompany(int companyID, UUID token) throws CustomExceptions;

    List<Company> getAllCompanies(UUID token);

    Company getOneCompany(int companyID, UUID token) throws CustomExceptions;

    List<Customer> getAllCustomers(UUID token);

    Customer getOneCustomer(int customerID, UUID token) throws CustomExceptions;

    void deleteCustomer(int customerID, UUID token) throws CustomExceptions;

    Customer updateCustomer(int customerID, Customer customer, UUID token) throws CustomExceptions;

    Customer addCustomer(Customer customer, UUID token) throws CustomExceptions;

//    boolean login(String email, String password);
}
