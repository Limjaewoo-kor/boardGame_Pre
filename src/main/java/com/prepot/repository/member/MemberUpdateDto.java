package com.prepot.repository.member;

import lombok.Data;

@Data
public class MemberUpdateDto {

    private String passWord;
    private String userName;
    private String addr;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String passWord, String userName, String addr) {
        this.passWord = passWord;
        this.userName = userName;
        this.addr = addr;
    }
}
