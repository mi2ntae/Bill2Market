package com.example.demo.model.item;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SimpleItem {

    private Integer itemId;
    private String itemTitle;
    private String itemAddress;
    private Integer price;
    private String itemPhoto;

    public SimpleItem(Integer itemId, String itemTitle, String itemAddress, Integer price, String itemPhoto){
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemAddress = itemAddress;
        this.price = price;
        this.itemPhoto = itemPhoto;
    }

}
