package com.jipbab.dto;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.ResImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResImgDto {
	private Long res_img_id;
	private String img_name;
	private String oriImgName;
	private String res_imgUrl;
	private String createdBy;
	private String modifiedBy;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ResImgDto of(ResImg resImg) {
		return modelMapper.map(resImg, ResImgDto.class);
	}
}
