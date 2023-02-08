package com.jipbab.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.Restaurant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantFormDto {
	private Long res_id;
	
	@NotBlank(message = "음식점 이름은 필수 입력 값입니다.")
	private String res_name;
	
	@NotNull(message = "시간은 필수 입력 값입니다.")
	private String time;
	
	@NotNull(message = "기본 정보는 필수 입력 값입니다.")
	private String information;
	
	private int heart;
	
	@NotNull(message = "위치는 필수 입력 값입니다.")
	private String location;
	
	private List<ResImgDto> resImgDtoList = new ArrayList(); //음식점 이미지 정보를 저장
	
	private List<Long> resImgIds = new ArrayList<>();
	
	private List<HashTagDto> hashTagDtoList = new ArrayList();
	
	private static ModelMapper modelMapper = new ModelMapper();
	public Restaurant createRest() {
		return modelMapper.map(this, Restaurant.class);
	}
	public static RestaurantFormDto of(Restaurant restaurant) {
		return modelMapper.map(restaurant, RestaurantFormDto.class);
	}

}
