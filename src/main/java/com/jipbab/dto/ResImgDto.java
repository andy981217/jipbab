package com.jipbab.dto;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.ResImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResImgDto {
	private Long id;
	private String imgName;
	private String oriImgName;
	private String resImgUrl;
	private String resRepimgYn;
	private String createdBy;
	private String modifiedBy;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ResImgDto of(ResImg resImg) {
		return modelMapper.map(resImg, ResImgDto.class);
	}
}
