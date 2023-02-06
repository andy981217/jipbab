package com.jipbab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jipbab.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email); //회원가입시 중복 회원이 있는 지 검사
}
