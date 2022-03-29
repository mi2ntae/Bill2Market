package com.example.demo.controller;

import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.exception.client.ClientNotFoundException;
import com.example.demo.exception.client.PasswordMisMatchException;
import com.example.demo.model.client.Client;
import com.example.demo.model.client.LoginRequest;
import com.example.demo.model.client.Role;
import com.example.demo.model.response.CommonResult;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. Auth"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final ResponseService responseService;

    @ApiOperation(value = "로그인", notes = "회원 로그인 기능")
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginRequest loginRequest){
        Client client = clientRepository.findById(loginRequest.getClientId()).orElseThrow(ClientNotFoundException::new);
        if (!passwordEncoder.matches(loginRequest.getPassword(), client.getPassword())) throw new PasswordMisMatchException();
        return responseService.getSingleResult(jwtTokenProvider.createToken(client.getClient_id(), client.getRole()));
    }

    @ApiOperation(value = "임시 회원가입", notes = "회원가입 기능")
    @PostMapping("/signup")
    public CommonResult signUp(String clientId, String password, String nickName){
        Client client = Client.builder()
                    .client_id(clientId)
                    .password(passwordEncoder.encode(password))
                    .nickname(nickName)
                    .role(Role.USER)
                    .build();
        clientRepository.save(client);
        return responseService.getSuccessfulResult();
    }


}
