package com.jipbab.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jipbab.dto.RestaurantFormDto;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@ToString
public class Restaurant extends BaseEntity{

	@Id
	@Column(name = "res_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //음식점 번호
	
	@Column(nullable = false)
	private String resName; //음식점 이름
	
	@Column(nullable = false)
	private String time1; //음식점 운영시간
	
	private String time2;

	
	@Column(nullable = false)
	private String information; //음식점 기본 정보
	
	private Integer heart; //음식점 좋아요 수
	
	@Column(nullable = false)
	private String location; //음식점 위치
	
	
	public void  createRestaurant(RestaurantFormDto restaurantFormDto) {
		this.resName=restaurantFormDto.getResName();
		this.time1 =restaurantFormDto.getTime1();
		this.time2 = restaurantFormDto.getTime2();
		this.information = restaurantFormDto.getInformation();
		this.heart = restaurantFormDto.getHeart();
		this.location = restaurantFormDto.getLocation();
	}
	
	
	public void updateRest(RestaurantFormDto restaurantFormDto) {
		this.resName = restaurantFormDto.getResName();
		this.time1 =  restaurantFormDto.getTime1();
		this.time2 = restaurantFormDto.getTime2();
		this.information = restaurantFormDto.getInformation();
		this.heart = restaurantFormDto.getHeart();
		this.location = restaurantFormDto.getLocation();
	}
	
	
}
