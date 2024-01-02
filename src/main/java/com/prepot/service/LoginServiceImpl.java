package com.prepot.service;

import com.prepot.domain.Member;
import com.prepot.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberRepository memberRepository;


    @Override
    public Member login(String loginId, String password) {

        Optional<Member> byLoginId2 = memberRepository.findById(loginId);

        Member member = byLoginId2.orElse(new Member("empty","empty","empty","empty"));

        if(!member.getUserName().equals("empty")){
            if (member.getPassWord().equals(password)) {
                return member;
            }
        }
        return null;
    }
}
