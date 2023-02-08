package com.jipbab.dto;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.RestHashTag;
import com.jipbab.entity.Restaurant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagDto {
	private Long id;
	private String tag;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static HashTagDto of(RestHashTag hashtag) {
		return modelMapper.map(hashtag, HashTagDto.class);
	}
	
}
