package com.example.jb.Project2Againwoohoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {

    private String key;
    private String value;

    public ErrorDetails(String value) {
        this.value = value;
    }
}