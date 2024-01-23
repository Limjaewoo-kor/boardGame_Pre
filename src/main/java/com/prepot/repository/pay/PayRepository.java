package com.prepot.repository.pay;

import com.prepot.domain.Food;
import com.prepot.domain.FoodOrder;
import com.prepot.domain.Pay;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PayRepository {

    void update(PayUpdateDto updateParam);

    Optional<Pay> findById();

}
