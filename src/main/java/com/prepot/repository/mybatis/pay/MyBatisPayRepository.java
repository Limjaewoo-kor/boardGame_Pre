package com.prepot.repository.mybatis.pay;

import com.prepot.domain.Pay;
import com.prepot.repository.pay.PayRepository;
import com.prepot.repository.pay.PayUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisPayRepository implements PayRepository {


    private final PayMapper payMapper;

    @Override
    public void update(PayUpdateDto updateParam) {
        payMapper.update(updateParam);
    }

    @Override
    public Optional<Pay> findById() {
        return payMapper.findById();
    }

}
