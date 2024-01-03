package com.prepot.repository.food;

import lombok.Data;

@Data
public class FoodUpdateDto {

    private String foodName;
    private Integer foodPrice;

    public FoodUpdateDto() {
    }

    public FoodUpdateDto(String foodName, Integer foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}
