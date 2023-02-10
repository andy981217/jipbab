package com.jipbab.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.jipbab.dto.RestSearchDto;
import com.jipbab.entity.QRestaurant;
import com.jipbab.entity.Restaurant;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class RestRepositoryCustomImpl implements RestRepositoryCustom {
	private JPAQueryFactory queryFactory;
	
	public RestRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("resName", searchBy)) {
			return QRestaurant.restaurant.resName.like("%"+searchQuery+"&");
		}else if(StringUtils.equals("information", searchBy)) {
			return QRestaurant.restaurant.information.like("%"+searchQuery+"%");
		}
		return null;
	}
	
	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();
		
		if(StringUtils.equals("all", searchDateType) || searchDateType == null)
			return null;
		else if(StringUtils.equals("1d", searchDateType))
			dateTime = dateTime.minusDays(1);
		else if(StringUtils.equals("1w", searchDateType))
			dateTime = dateTime.minusWeeks(1);
		else if(StringUtils.equals("1m", searchDateType))
			dateTime = dateTime.minusMonths(1);
		else if(StringUtils.equals("6m", searchDateType))
			dateTime = dateTime.minusMonths(6);
		
		return QRestaurant.restaurant.regTime.after(dateTime);
	}

	@Override
	public Page<Restaurant> getAdminRestPage(RestSearchDto restSearchDto, Pageable pageable) {
		List<Restaurant> content = queryFactory.selectFrom(QRestaurant.restaurant)
				.where(regDtsAfter(restSearchDto.getSearchDateType()),
						searchByLike(restSearchDto.getSearchBy(),restSearchDto.getSearchQuery()))
				.orderBy(QRestaurant.restaurant.id.desc()).offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
	
			long total = queryFactory.select(Wildcard.count).from(QRestaurant.restaurant)
					.where(regDtsAfter(restSearchDto.getSearchDateType()),
						searchByLike(restSearchDto.getSearchBy(), restSearchDto.getSearchQuery()))
					.fetchOne()	;
			
			return new PageImpl<>(content,pageable,total);
					
					
	}
	

	
}
