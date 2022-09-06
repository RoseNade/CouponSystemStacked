package com.example.jb.Project2Againwoohoo.dto;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginPayloadDto {
    private String email;
    private String password;
    private ClientType clientType;
}
