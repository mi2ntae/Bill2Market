package com.example.demo.model.basket;

import lombok.Data;
import java.io.Serializable;

@Data
public class BasketPK implements Serializable {
    private int client_index;
    private int item_id;
}
