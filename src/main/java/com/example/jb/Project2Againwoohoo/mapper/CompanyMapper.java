package com.example.jb.Project2Againwoohoo.mapper;

import com.example.jb.Project2Againwoohoo.beans.Company;
import com.example.jb.Project2Againwoohoo.dto.CompanyPayloadDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements Mapper<Company, CompanyPayloadDto> {
    @Override
    public Company toDao(CompanyPayloadDto dPayloadDTOd) {
        return Company.builder()
                .email(dPayloadDTOd.getEmail())
                .password(dPayloadDTOd.getPassword())
                .name(dPayloadDTOd.getName())
                .build();
    }
    @Override
    public CompanyPayloadDto toPayloadDTO(Company company) {
        return CompanyPayloadDto.builder()
                .email(company.getEmail())
                .password(company.getPassword())
                .name(company.getName())
                .build();
    }

    @Override
    public List<Company> toDaoList(List<CompanyPayloadDto> companyPayloadDtos) {
        return companyPayloadDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CompanyPayloadDto> toPayloadDTOList(List<Company> companies) {
        return companies.stream().map(this::toPayloadDTO).collect(Collectors.toList());
    }
}
