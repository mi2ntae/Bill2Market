package com.example.demo.model.item;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Item_Photo")
public class ItemPhoto {
    @Id
    @Column(name = "photo_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photoIndex;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_photo")
    private String itemPhoto;

}
