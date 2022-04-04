package com.example.demo.model.client;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.sql.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Client2")
public class Client {
    @Id
    @Column(name = "client_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientIndex;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "password")
    private String password;
    @Column
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private Date birthdate;
    @Column(name = "sns_type")
    private int snsType;
    @Column(name = "client_name")
    private String clientName;
    @Column
    private String nickname;
    @Column
    private int subscribe;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}