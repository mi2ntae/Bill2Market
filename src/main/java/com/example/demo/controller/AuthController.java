package com.example.demo.controller;

import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.exception.client.ClientNotFoundException;
import com.example.demo.exception.client.ExistIdException;
import com.example.demo.exception.client.InputNullException;
import com.example.demo.exception.client.PasswordMisMatchException;
import com.example.demo.model.client.Client;
import com.example.demo.model.client.LoginRequest;
import com.example.demo.model.client.Role;
import com.example.demo.model.client.SignupRequest;
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
        Client client = clientRepository.findByClientId(loginRequest.getClientId()).orElseThrow(ClientNotFoundException::new);
        if (!passwordEncoder.matches(loginRequest.getPassword(), client.getPassword())) throw new PasswordMisMatchException();
        return responseService.getSingleResult(jwtTokenProvider.createToken(client.getClientIndex(), client.getRole()));
    }

    @ApiOperation(value = "회원가입", notes = "회원가입 기능")
    @PostMapping("/signup")
    public CommonResult signUp(@RequestBody SignupRequest signupRequest){
        if(clientRepository.findByClientId(signupRequest.getClientId()).isPresent()) throw new ExistIdException(); //이미 존재하는 ID exception
        if(signupRequest.getClientId() ==null || signupRequest.getPassword() == null ||signupRequest.getClientName() == null
                || signupRequest.getNickname() == null || signupRequest.getEmail() == null
                || signupRequest.getPhoneNumber() == null) throw new InputNullException(); //입력창에 Null값이 있을 시 InputNullException 오류
        clientRepository.save(signupRequest.toEntity(passwordEncoder));
        return responseService.getSuccessfulResult();
    }
}
