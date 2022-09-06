package com.example.jb.Project2Againwoohoo.controllers;

import com.example.jb.Project2Againwoohoo.dto.LoginPayloadDto;
import com.example.jb.Project2Againwoohoo.dto.RegisterPayloadDto;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.security.Info;
import com.example.jb.Project2Againwoohoo.security.LoginInformation;
import com.example.jb.Project2Againwoohoo.security.TokenManager;
import com.example.jb.Project2Againwoohoo.services.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/welcome")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WelcomeController {
    private final WelcomeService welcomeService;

    private final TokenManager tokenManager;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterPayloadDto registerPayloadDto) throws Exception {
        welcomeService.register(registerPayloadDto.getEmail(), registerPayloadDto.getPassword(), registerPayloadDto.getName(), registerPayloadDto.getClientType());
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginInformation login(@RequestBody LoginPayloadDto loginPayloadDto) throws CouponSecurityExceptions {
        Info info = tokenManager.getMap().get(welcomeService.login(loginPayloadDto.getEmail(), loginPayloadDto.getPassword(), loginPayloadDto.getClientType()));
        return new LoginInformation(info.getUserId(), info.getName(), info.getClientType(), loginPayloadDto.getEmail(), welcomeService.login(loginPayloadDto.getEmail(), loginPayloadDto.getPassword(), loginPayloadDto.getClientType()));
    }
}
