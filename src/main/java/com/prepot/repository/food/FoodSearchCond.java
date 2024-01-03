package com.prepot.repository.food;

import lombok.Data;

@Data
public class FoodSearchCond {

    private String foodName;
    private Integer foodPrice;

    public FoodSearchCond() {
    }

    public FoodSearchCond(String foodName, Integer foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}
