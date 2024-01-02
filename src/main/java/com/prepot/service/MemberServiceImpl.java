package com.prepot.service;

import com.prepot.domain.Member;
import com.prepot.repository.member.MemberRepository;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findMembers(MemberSearchCond memberSearchCond) {
        return memberRepository.findAll(memberSearchCond);
    }

    @Override
    public void update(String userId, MemberUpdateDto updateParam) {
        memberRepository.update(userId,updateParam);
    }

    @Override
    public Optional<Member> findById(String userId) {
        return memberRepository.findById(userId);
    }

    @Override
    public void deleteMember(String userId) {
        memberRepository.deleteMember(userId);
    }

}
