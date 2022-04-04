package com.example.demo.model.review;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Review_Photo")
public class Review_Photo {
    @Id
    private int review_photo_index;

    @Column(nullable = false)
    private int contract_id;
    private String review_photo;
}
