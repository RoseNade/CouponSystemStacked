package com.example.jb.Project2Againwoohoo.security;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LoginInformation {
    private int userId;
    private String name;
    private ClientType clientType;
    private String email;
    private UUID token;
}
