package com.prepot.domain;

import lombok.Data;

@Data
public class Pay {


    private int roomPrice;


    public Pay() {
    }

    public Pay(int roomPrice) {
        this.roomPrice = roomPrice;
    }
}
