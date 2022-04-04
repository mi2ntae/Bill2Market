package com.example.demo.model.client;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@Data
public class SignupRequest {
    private String clientId;
    private String clientName;
    private String password;
    private String nickname;
    private String email;
    private Date birthdate;
    private String phoneNumber;
    private Role role;

    public Client toEntity(PasswordEncoder passwordEncoder) {
        Client client = new Client();
        client.setClientId(clientId);
        client.setPassword(passwordEncoder.encode(password));
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setClientName(clientName);
        client.setNickname(nickname);
        client.setBirthdate(birthdate);
        client.setRole(Role.USER);
        client.setSnsType(1);

        return client;
    }
}
