package com.jipbab.dto;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.HashTag;
import com.jipbab.entity.Restaurant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagDto {
	private Long id;
	private String tag; //태그 이름
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static HashTagDto of(HashTag hashtag) {
		return modelMapper.map(hashtag, HashTagDto.class);
	}
	
}
