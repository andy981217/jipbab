package com.jipbab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "res_img") //테이블명
@Getter
@Setter
@ToString
public class ResImg extends BaseEntity{
	@Id
	@Column(name = "res_img_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long res_img_id;
	
	private String img_name; //이미지 파일명
	private String res_oriImgName; //원본 이미지 파일명
	private String res_imgUrl; //이미지 조회 경로
	private String res_repimgYn; //대표 이미지 여부
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="res_id")
	private Restaurant restaurant;
	
	public void updateResImg(String res_oriImgName,String img_name, String res_imgUrl) {
		this.res_oriImgName = res_oriImgName;
		this.img_name = img_name;
		this.res_imgUrl = res_imgUrl;
	}
}
