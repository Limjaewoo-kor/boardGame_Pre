package com.prepot.service;

import com.prepot.domain.Food;
import com.prepot.domain.Game;
import com.prepot.repository.food.FoodRepository;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.repository.game.GameRepository;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> findFoods(FoodSearchCond foodSearchCond) {
        return foodRepository.findAll(foodSearchCond);
    }

    @Override
    public void update(String foodName, FoodUpdateDto updateParam) {
        foodRepository.update(foodName,updateParam);
    }

    @Override
    public Optional<Food> findById(String foodName) {
        return foodRepository.findById(foodName);
    }

    @Override
    public void deleteFood(String foodName) {
        foodRepository.deleteFood(foodName);
    }

    @Override
    public void playFood(String foodName,String userId) {
        foodRepository.playFood(foodName,userId);
    }

    @Override
    public String playFoodCheck(String foodName, String userId) {
        return foodRepository.playFoodCheck(foodName,userId);
    }

    @Override
    public void endTimeUpdate(String foodName, String userId) {
        foodRepository.endTimeUpdate(foodName,userId);
    }

    @Override
    public void endFood(String userId) {
        foodRepository.endFood(userId);
    }

}
