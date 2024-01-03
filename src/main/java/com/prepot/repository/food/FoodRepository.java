package com.prepot.repository.food;

import com.prepot.domain.Food;
import com.prepot.domain.Game;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    Food save(Food food);

    List<Food> findAll(FoodSearchCond foodSearchCond);

    void update(String foodName, FoodUpdateDto updateParam);

    Optional<Food> findById(String foodName);

    void deleteFood(String foodName);

    void playFood(String foodName,String userId);

    String playFoodCheck(String foodName, String userId);

    void endTimeUpdate(String foodName, String userId);

    void endFood(String userId);
}
