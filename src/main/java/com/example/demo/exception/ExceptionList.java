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
    ACCESS_DENIED(-1003, "권한이 부족하여 해당 기능을 이용하실 수 없습니다."),
    INPUT_NULL(-1004, "입력하지 않은 값이 있습니다."),
    EXIST_ID(-1005, "이미 존재하는 아이디입니다."),
    HTTP_FAIL(-1006, "외부 서버와 연결에 실패했습니다."),
    ITEM_NOT_FOUND(-1007, "해당 물품이 존재하지 않습니다."),
    BASKET_NOT_FOUND(-1008, "해당 찜이 존재하지 않습니다."),
    DUPLICATE_BASKET(-1009, "이미 찜이 되어있는 물품입니다."),
    EXIST_NICKNAME(-1010, "현재 존재하는 닉네임입니다.");

    private final int code;
    private final String message;
}
