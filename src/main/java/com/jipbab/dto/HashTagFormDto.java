package com.jipbab.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;

import com.jipbab.entity.HashTag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagFormDto {
	private Long id;
	
	@NotBlank(message = "태그는 필수 입력 값입니다.")
	private String tag;
	
	private List<HashTagDto> hashTagDtoList = new ArrayList();
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public HashTag createTag() {
		return modelMapper.map(this, HashTag.class);
	}
	public static HashTagFormDto of(HashTag restHashTag) {
		return modelMapper.map(restHashTag, HashTagFormDto.class);
	}
}

