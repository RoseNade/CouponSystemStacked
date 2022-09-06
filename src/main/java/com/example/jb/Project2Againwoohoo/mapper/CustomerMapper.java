package com.example.jb.Project2Againwoohoo.mapper;

import com.example.jb.Project2Againwoohoo.beans.Customer;
import com.example.jb.Project2Againwoohoo.dto.CustomerPayloadDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerPayloadDto> {

    @Override
    public Customer toDao(CustomerPayloadDto customerPayloadDto) {
        return Customer.builder()
                .email(customerPayloadDto.getEmail())
                .password(customerPayloadDto.getPassword())
                .lastName(customerPayloadDto.getLastName())
                .firstName(customerPayloadDto.getFirstName())
                .build();
    }

    @Override
    public CustomerPayloadDto toPayloadDTO(Customer customer) {
        return CustomerPayloadDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .build();
    }

    @Override
    public List<Customer> toDaoList(List<CustomerPayloadDto> customerPayloadDtos) {
        return customerPayloadDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CustomerPayloadDto> toPayloadDTOList(List<Customer> customers) {
        return customers.stream().map(this::toPayloadDTO).collect(Collectors.toList());
    }
}
