package com.prepot.domain;

import lombok.Data;

@Data
public class Food {

    private String foodName;
    private int foodPrice;


    public Food() {
    }

    public Food(String foodName, int foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}
