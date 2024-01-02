package com.prepot.service;

import com.prepot.domain.Member;
import com.prepot.repository.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    private MemberRepository memberRepository;
    @Test
    void save() {

        Member m = new Member();
        m.setUserName("name");


        Assertions.assertThat(m.getUserName()).isEqualTo("test");
    }
}