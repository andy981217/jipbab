package com.jipbab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.jipbab.dto.HashTagDto;
import com.jipbab.entity.HashTag;

public interface HashRepository extends JpaRepository<HashTag, Long>, QuerydslPredicateExecutor<HashTag>,HashRepositoryCustom {

}
