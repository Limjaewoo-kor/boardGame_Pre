package com.prepot.repository.food;

import com.prepot.domain.Food;
import com.prepot.domain.FoodOrder;
import com.prepot.domain.Game;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    Food save(Food food);

    List<Food> findAll(FoodSearchCond foodSearchCond);

    void update(String foodName, FoodUpdateDto updateParam);

    Optional<Food> findById(String foodName);

    void deleteFood(String foodName);

    void endTimeUpdate(String foodName, String userId);

    void endFood(String userId);

    void orderFood(String foodName, String foodPrice, String foodCnt, String userId);

    List<FoodOrder> findFoodOrders(FoodSearchCond foodSearchCond, String userId);
}
