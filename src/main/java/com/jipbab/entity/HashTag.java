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
@Table(name = "hash_tag")
@Getter
@Setter
@ToString
public class HashTag extends BaseEntity{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tag; //태그 이름
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_id")
	private Restaurant restaurant;

}
