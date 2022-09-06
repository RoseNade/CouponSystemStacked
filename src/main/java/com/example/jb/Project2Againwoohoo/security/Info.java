package com.example.jb.Project2Againwoohoo.security;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Info {
    private int userId;
    private String name;
    private ClientType clientType;
    private LocalDateTime time;
    private String email;
}
