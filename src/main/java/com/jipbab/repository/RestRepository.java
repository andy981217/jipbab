package com.jipbab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.jipbab.entity.Restaurant;

public interface RestRepository extends JpaRepository<Restaurant, Long>,QuerydslPredicateExecutor<Restaurant>, RestRepositoryCustom{
//	List<Restaurant> findByRes_name(String res_name);
}
