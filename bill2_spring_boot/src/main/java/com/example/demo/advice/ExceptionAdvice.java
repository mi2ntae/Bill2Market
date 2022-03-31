package com.example.demo.advice;

import com.example.demo.exception.ExceptionList;
import com.example.demo.exception.client.CAccessDeniedException;
import com.example.demo.exception.client.CAuthenticationEntryPointException;
import com.example.demo.exception.client.ClientNotFoundException;
import com.example.demo.exception.client.PasswordMisMatchException;
import com.example.demo.exception.item.ItemNotFoundException;
import com.example.demo.model.response.CommonResult;
import com.example.demo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult unknown(){
        return responseService.getFailResult(ExceptionList.UNKNOWN.getCode(), ExceptionList.UNKNOWN.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult clientNotFoundException(){
        return responseService.getFailResult(ExceptionList.CLIENT_NOT_FOUNT.getCode(), ExceptionList.CLIENT_NOT_FOUNT.getMessage());
    }

    @ExceptionHandler(PasswordMisMatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult passwordMisMatchException(){
        return responseService.getFailResult(ExceptionList.PASSWORD_MISMATCH.getCode(), ExceptionList.PASSWORD_MISMATCH.getMessage());
    }

    @ExceptionHandler(CAuthenticationEntryPointException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult authenticationEntryPointException(){
        return responseService.getFailResult(ExceptionList.AUTHENTICATION_ENTRYPOINT.getCode(), ExceptionList.AUTHENTICATION_ENTRYPOINT.getMessage());
    }

    @ExceptionHandler(CAccessDeniedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult accessDeniedException(){
        return responseService.getFailResult(ExceptionList.ACCESS_DENIED.getCode(), ExceptionList.ACCESS_DENIED.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected  CommonResult itemNotFoundException(){
        return responseService.getFailResult(ExceptionList.ITEM_NOT_FOUND.getCode(), ExceptionList.ITEM_NOT_FOUND.getMessage());
    }

}
