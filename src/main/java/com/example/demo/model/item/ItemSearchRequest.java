package com.example.demo.model.item;

import lombok.Data;

@Data
public class ItemSearchRequest {

    private double longitude;
    private double latitude;
    private Integer page;

}
