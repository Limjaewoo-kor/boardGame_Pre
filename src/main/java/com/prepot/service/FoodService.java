package com.prepot.service;

import com.prepot.domain.Food;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    Food save(Food food);

    List<Food> findFoods(FoodSearchCond foodSearchCond);

    void update(String userId, FoodUpdateDto updateParam);

    Optional<Food> findById(String foodName);

    void deleteFood(String foodName);

    void playFood(String foodName,String userId);

    String playFoodCheck(String foodName, String userId);

    void endTimeUpdate(String foodName, String userId);

    void endFood(String userId);
}
