package com.example.demo.model.client;

import lombok.*;

import javax.persistence.*;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Client")
public class Client {
    @Id
    private String client_id;
    @Column(nullable = false)
    private String password;
    private String name;
    private String nickname;
    private String address;
    private String email;
    private String phone_number;
    private int age;
    private int trust_point;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
