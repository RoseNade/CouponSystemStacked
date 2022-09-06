package com.example.jb.Project2Againwoohoo.dto;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterPayloadDto {
    private String email;
    private String name;
    private String password;
    private ClientType clientType;
}
