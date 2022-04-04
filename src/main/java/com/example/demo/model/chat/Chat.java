package com.example.demo.model.chat;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Chat")
public class Chat {
    @Id
    private int chat_id;

    @Column(nullable = false)
    private int lenter_index;
    private int item_id;
    private Date create_date;
    private Date update_date;
}
