package com.prepot.repository.mybatis.food;


import com.prepot.domain.Food;
import com.prepot.domain.FoodOrder;
import com.prepot.domain.Game;
import com.prepot.repository.food.FoodRepository;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisFoodRepository implements FoodRepository {

    private final FoodMapper foodMapper;

    @Override
    public Food save(Food food) {
        log.info("m class={}", foodMapper.getClass());
        foodMapper.save(food);
        return food;
    }

    @Override
    public List<Food> findAll(FoodSearchCond foodSearchCond) {
        return foodMapper.findAll(foodSearchCond);
    }

    @Override
    public void update(String foodName, FoodUpdateDto updateParam) {
        foodMapper.update(foodName,updateParam);
    }

    @Override
    public Optional<Food> findById(String foodName) {
        return foodMapper.findById(foodName);
    }

    @Override
    public void deleteFood(String foodName) {
        foodMapper.deleteFood(foodName);
    }

    @Override
    public void endTimeUpdate(String foodName, String userId) {
        foodMapper.endTimeUpdate(foodName,userId);
    }

    @Override
    public void endFood(String userId) {
        foodMapper.endFood(userId);
    }

    @Override
    public void orderFood(String foodName, String foodPrice, String foodCnt, String userId) {
        foodMapper.orderFood(foodName,foodPrice,foodCnt,userId);
    }

    @Override
    public List<FoodOrder> findFoodOrders(FoodSearchCond foodSearchCond, String userId) {
        return foodMapper.findFoodOrders(foodSearchCond.getFoodName(), String.valueOf(foodSearchCond.getFoodPrice()),userId);
    }

}
