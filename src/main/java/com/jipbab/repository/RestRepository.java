package com.jipbab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.jipbab.entity.Restaurant;

public interface RestRepository extends JpaRepository<Restaurant, Long>,QuerydslPredicateExecutor<Restaurant>, RestRepositoryCustom{
	List<Restaurant> findByresName(String resName);
	
	
	List<Restaurant> findByHeartLessThan(Integer heart);
	
	List<Restaurant> findByHeartLessThanOrderByHeartDesc(Integer Heart);
	
	@Query("select r from Restaurant r where r.information like %?1% order by r.heart desc")
	List<Restaurant> findByInformation(String information);

	@Query(value = "select * from restaurant r where r.information like %:information% order by r.heart desc",nativeQuery =true)
	List<Restaurant> findByinformationByNative(@Param("information")String information);
}
