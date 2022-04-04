package com.example.demo.model.client;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.sql.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Client2")
public class ClientVO {
    @Id
    private int client_index;
    @Column(nullable = false)
    private String client_id;
    private String password;
    private String email;
    private String phone_number;
    private String client_name;
    private String nickname;
    private String client_photo;
    private int sns_type;
    private Date birthdate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean subscribe;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
