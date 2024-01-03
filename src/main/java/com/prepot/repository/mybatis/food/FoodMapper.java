package com.prepot.repository.mybatis.food;

import com.prepot.domain.Food;
import com.prepot.domain.Game;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FoodMapper {

    void save(Food member);

    List<Food> findAll(FoodSearchCond foodSearchCond);

    void update(@Param("foodName") String foodName, @Param("updateParam") FoodUpdateDto updateParam);

    Optional<Food> findById(String foodName);

    void deleteFood(String foodName);

    void playFood(@Param("foodName") String foodName,@Param("userId")String userId);

    String playFoodCheck(@Param("foodName") String foodName,@Param("userId")String userId);

    void endTimeUpdate(@Param("foodName") String foodName,@Param("userId")String userId);

    void endFood(String userId);

}
