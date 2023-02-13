package com.jipbab.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainRestDto {
	private Long id;
	
	private String resName;
	
	private String information;
	
	private String resImgUrl;
	
	@QueryProjection
	public MainRestDto(Long id, String resName, String information, String resImgUrl) {
		this.id=id;
		this.resName = resName;
		this.information = information;
		this.resImgUrl = resImgUrl;
		
	}
}
