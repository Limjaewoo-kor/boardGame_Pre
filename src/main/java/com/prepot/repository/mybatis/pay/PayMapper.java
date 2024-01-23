package com.prepot.repository.mybatis.pay;

import com.prepot.domain.Pay;
import com.prepot.repository.pay.PayUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface PayMapper {


    void update(@Param("updateParam") PayUpdateDto updateParam);

    Optional<Pay> findById();

}
