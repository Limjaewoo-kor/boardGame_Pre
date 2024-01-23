package com.prepot.domain;

import lombok.Data;

@Data
public class FoodOrder {

    private String foodName;
    private String foodPrice;
    private String foodCnt;
    private String userId;


    public FoodOrder() {
    }

    public FoodOrder(String foodName, String foodPrice, String foodCnt) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodCnt = foodCnt;
    }
}
