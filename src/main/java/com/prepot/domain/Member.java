package com.prepot.domain;

import lombok.Data;

@Data
public class Member {

    private String userId;
    private String passWord;
    private String userName;
    private String addr;

    public Member() {
    }

    public Member(String userId, String passWord, String userName, String addr) {
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
        this.addr = addr;
    }
}
