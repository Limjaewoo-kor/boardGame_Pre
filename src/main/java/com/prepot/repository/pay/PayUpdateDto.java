package com.prepot.repository.pay;

import lombok.Data;

@Data
public class PayUpdateDto {

    private Integer roomPrice;

    public PayUpdateDto() {
    }

    public PayUpdateDto(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }
}
