package com.example.demo.model.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "사용자");

    private final String key;
    private final String title;

}
