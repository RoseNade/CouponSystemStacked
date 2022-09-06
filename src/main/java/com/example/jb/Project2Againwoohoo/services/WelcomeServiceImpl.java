package com.example.jb.Project2Againwoohoo.services;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.ErrMsg;
import com.example.jb.Project2Againwoohoo.exceptions.SecurityErrMsg;
import com.example.jb.Project2Againwoohoo.repositories.CompanyRepo;
import com.example.jb.Project2Againwoohoo.repositories.CustomerRepo;
import com.example.jb.Project2Againwoohoo.security.Info;
import com.example.jb.Project2Againwoohoo.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService {

    private final CompanyRepo companyRepo;

    private final CustomerRepo customerRepo;

    private final TokenManager tokenManager;

    @Override
    public void register(String email, String password, String name, ClientType clientType) throws CustomExceptions, CouponSecurityExceptions {
        switch (clientType) {
            case COMPANY:
                if (companyRepo.existsByEmail(email)) {
                    throw new CustomExceptions(ErrMsg.EMAIL_ALREADY_EXISTS);
                }

                if (companyRepo.existsByName(name)) {
                    throw new CustomExceptions(ErrMsg.NAME_ALREADY_EXISTS);
                }

                Company company = Company.builder()
                        .name(name)
                        .email(email)
                        .password(password)
                        .build();

                companyRepo.save(company);
                return;

            case CUSTOMER:
                if (customerRepo.existsByEmail(email)) {
                    throw new CustomExceptions(ErrMsg.EMAIL_ALREADY_EXISTS);
                }

                String[] fullName = name.split(" ");

                // build the customer object
                Customer customer = Customer.builder()
                        .firstName(fullName[0])
                        .lastName(fullName[1])
                        .password(password)
                        .email(email)
                        .build();

                customerRepo.save(customer);
                return;
        }
        throw new CouponSecurityExceptions(SecurityErrMsg.INVALID_CLIENT_TYPE);
    }

    @Override
    public UUID login(String email, String password, ClientType clientType) throws CouponSecurityExceptions {
        switch (clientType) {
            case ADMIN:
                if(email.equals("admin@admin.com") && password.equals("admin")){
                    return tokenManager.add(new Info(0, "ADMIN", clientType, LocalDateTime.now(), email));
                }
                throw new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG);

            case COMPANY:
                if (!companyRepo.existsByEmailAndPassword(email, password)) {
                    throw new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG);
                }
                Company company = companyRepo.findByEmailAndPassword(email, password);
                return tokenManager.add(new Info(company.getId(), company.getName(), clientType, LocalDateTime.now(), email));

            case CUSTOMER:
                if (!customerRepo.existsByEmailAndPassword(email, password)) {
                    throw new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG);
                }
                Customer customer = customerRepo.findByEmailAndPassword(email, password).orElseThrow(() -> new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG));
                return tokenManager.add(new Info(customer.getId(), customer.getFirstName(), clientType, LocalDateTime.now(), email));
        }
        return null;
    }
}
