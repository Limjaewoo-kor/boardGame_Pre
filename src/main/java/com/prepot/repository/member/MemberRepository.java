package com.prepot.repository.member;

import com.prepot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll(MemberSearchCond memberSearchCond);

    void update(String userId, MemberUpdateDto updateParam);

    Optional<Member> findById(String userId);

    void deleteMember(String userId);
}
