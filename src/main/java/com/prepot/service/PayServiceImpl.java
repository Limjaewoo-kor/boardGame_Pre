package com.prepot.service;

import com.prepot.domain.Food;
import com.prepot.domain.Pay;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.repository.pay.PayRepository;
import com.prepot.repository.pay.PayUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PayRepository payRepository;

    @Override
    public void update( PayUpdateDto updateParam) {
        payRepository.update(updateParam);
    }

    @Override
    public Optional<Pay> findById() {
        return payRepository.findById();
    }


}
