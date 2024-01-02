package com.prepot.repository.member;

import lombok.Data;

@Data
public class MemberSearchCond {

    private String userId;
    private String userName;

    public MemberSearchCond() {
    }

    public MemberSearchCond(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
