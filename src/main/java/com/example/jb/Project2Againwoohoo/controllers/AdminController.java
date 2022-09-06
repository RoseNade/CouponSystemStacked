package com.example.jb.Project2Againwoohoo.controllers;

import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.dto.CompanyPayloadDto;
import com.example.jb.Project2Againwoohoo.dto.CustomerPayloadDto;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody @Valid CustomerPayloadDto customer, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        return adminService.addCustomer(new Customer(customer), token);
    }

    @DeleteMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int customerId, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        adminService.deleteCustomer(customerId, token);
    }

    @PutMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody @Valid CustomerPayloadDto customerPayloadDto, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        return adminService.updateCustomer(customerId, new Customer(customerPayloadDto), token);
    }

    @GetMapping("customers")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token){
        return adminService.getAllCustomers(token);
    }

    @GetMapping("customers/{customerId}")
    public Customer getOneCustomer(@PathVariable int customerId, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        return adminService.getOneCustomer(customerId, token);
    }

    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody @Valid CompanyPayloadDto companyPayloadDto, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        Company company = new Company(companyPayloadDto);
        adminService.addCompany(new Company(companyPayloadDto), token);
        return company;
    }

    @PutMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Company updateCompany(@PathVariable int companyId, @RequestBody @Valid CompanyPayloadDto companyPayloadDto, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        return adminService.updateCompany(companyId, new Company(companyPayloadDto), token);
    }

    @DeleteMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int companyId, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        adminService.deleteCompany(companyId, token);
    }

    @GetMapping("companies")
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token){
        return adminService.getAllCompanies(token);
    }

    @GetMapping("companies/{companyId}")
    public Company getOneCompany(@PathVariable int companyId, @RequestHeader("Authorization") UUID token) throws CustomExceptions {
        return adminService.getOneCompany(companyId, token);
    }
}
