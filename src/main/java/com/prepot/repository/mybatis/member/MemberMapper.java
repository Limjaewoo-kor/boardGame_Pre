package com.prepot.repository.mybatis.member;

import com.prepot.domain.Member;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);

    List<Member> findAll(MemberSearchCond memberSearchCond);

    void update(@Param("userId") String userId, @Param("updateParam") MemberUpdateDto updateParam);

    Optional<Member> findById(String userId);

    void deleteMember(String userId);
}
