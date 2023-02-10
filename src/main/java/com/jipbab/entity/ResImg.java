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
	@Column(name = "res_Img_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resImgId;
	
	private String imgName; //이미지 파일명
	private String oriImgName; //원본 이미지 파일명
	private String resImgUrl; //이미지 조회 경로
	private String resRepimgYn; //대표 이미지 여부
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="res_id")
	private Restaurant restaurant;
	
	public void updateResImg(String oriImgName,String imgName, String resImgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.resImgUrl = resImgUrl;
	}
}
