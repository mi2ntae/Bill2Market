package com.example.demo.model.chat;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Chat_Message")
public class Chat_Message {
    @Id
    private int message_id;

    @Column(nullable = false)
    private int chat_id;
    private int from_index;
    private int to_index;
    private String chat_content;
    private Date create_date;
    private Date update_date;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean read_status;
}
