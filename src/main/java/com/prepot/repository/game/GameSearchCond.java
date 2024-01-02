package com.prepot.repository.game;

import lombok.Data;

@Data
public class GameSearchCond {

    private String gameName;
    private Integer userCnt;

    public GameSearchCond() {
    }

    public GameSearchCond(String gameName, Integer userCnt) {
        this.gameName = gameName;
        this.userCnt = userCnt;
    }
}
