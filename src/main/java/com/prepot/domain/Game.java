package com.prepot.domain;

import lombok.Data;

@Data
public class Game {

    private String gameName;
    private int minCnt;
    private int maxCnt;
    private int gameCnt;
    private int nowCnt;

    public Game() {
    }

    public Game(String gameName, int minCnt, int maxCnt, int gameCnt) {
        this.gameName = gameName;
        this.minCnt = minCnt;
        this.maxCnt = maxCnt;
        this.gameCnt = gameCnt;
    }
}
