package com.prepot.repository.game;

import lombok.Data;

@Data
public class GameUpdateDto {

    private int minCnt;
    private int maxCnt;
    private int gameCnt;

    public GameUpdateDto() {
    }

    public GameUpdateDto(int minCnt, int maxCnt, int gameCnt) {
        this.minCnt = minCnt;
        this.maxCnt = maxCnt;
        this.gameCnt = gameCnt;
    }
}
