package com.jipbab.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
public class RestaurantDto {
	private Long res_id; //음식점 번호
	private String res_name; //음식점 이름
	private String time1; //음식점 운영 시간
	private String time2;
	private String information; //음식점 기본 정보
	private Integer heart; //음식점 좋아요 수
	private String location; //음식점 위치
	private LocalDateTime regTime; // 등록시간
	private LocalDateTime updateTime; // 수정시간
	private String createdBy; 
	private String modifiedBy;
}
