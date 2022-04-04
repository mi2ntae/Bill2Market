package com.example.demo.model.contract;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;
import java.sql.Time;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Contract")
public class Contract {
    @Id
    @Column(name = "contract_id")
    private int contract_id;

    @Column(nullable = false)
    private int chat_id;
    private Date contract_date;
    private Date start_date;
    private Date end_date;
    private int contract_status;
}
