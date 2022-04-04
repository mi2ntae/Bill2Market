package com.example.demo.model.item;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Item_Photo")
public class Item_Photo {
    @Id
    private int item_photo_index;

    @Column(nullable = false)
    private int item_id;
    private String item_photo;
}
