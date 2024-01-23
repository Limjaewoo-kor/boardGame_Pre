package com.prepot.repository.pay;

import lombok.Data;

@Data
public class PaySearchCond {

    private String userName;
    private Integer userPrice;

    public PaySearchCond() {
    }

    public PaySearchCond(String userName, Integer userPrice) {
        this.userName = userName;
        this.userPrice = userPrice;
    }
}
