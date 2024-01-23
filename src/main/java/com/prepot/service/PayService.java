package com.prepot.service;

import com.prepot.domain.Food;
import com.prepot.domain.FoodOrder;
import com.prepot.domain.Pay;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.repository.pay.PayUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PayService {

    void update(PayUpdateDto updateParam);

    Optional<Pay> findById();

}
