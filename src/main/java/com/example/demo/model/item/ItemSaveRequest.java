package com.example.demo.model.item;

import lombok.Data;

@Data
public class ItemSaveRequest {

    private String itemTitle;
    private double itemLatitude;
    private double itemLongitude;

    public Item toEntity(){
        return Item.builder()
                .itemTitle(itemTitle)
                .itemLatitude(itemLatitude)
                .itemLongitude(itemLongitude)
                .build();
    }

}
