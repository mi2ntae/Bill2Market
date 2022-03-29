package com.example.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionList {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),
    CLIENT_NOT_FOUNT(-1000, "해당 사용자가 존재하지 않습니다."),
    PASSWORD_MISMATCH(-1001, "비밀번호가 일치하지 않습니다."),
    AUTHENTICATION_ENTRYPOINT(-1002, "해당 기능을 이용하기 위한 권한이 없습니다."),
    ACCESS_DENIED(-1003, "권한이 부족하여 해당 기능을 이용하실 수 없습니다.");

    private final int code;
    private final String message;
}
