package com.prepot.repository.mybatis.member;


import com.prepot.domain.Member;
import com.prepot.repository.member.MemberRepository;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        log.info("m class={}", memberMapper.getClass());
        memberMapper.save(member);
        return member;
    }

    @Override
    public List<Member> findAll(MemberSearchCond memberSearchCond) {
        return memberMapper.findAll(memberSearchCond);
    }

    @Override
    public void update(String userId, MemberUpdateDto updateParam) {
        memberMapper.update(userId,updateParam);
    }

    @Override
    public Optional<Member> findById(String userId) {
        return memberMapper.findById(userId);
    }

    @Override
    public void deleteMember(String userId) {
        memberMapper.deleteMember(userId);
    }

}
