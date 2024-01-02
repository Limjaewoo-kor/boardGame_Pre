package com.prepot.service;

import com.prepot.domain.Member;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member save(Member member);

    List<Member> findMembers(MemberSearchCond memberSearchCond);

    void update(String userId, MemberUpdateDto updateParam);

    Optional<Member> findById(String userId);

    void deleteMember(String userId);
}
