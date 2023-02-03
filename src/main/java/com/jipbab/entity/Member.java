package com.jipbab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jipbab.constant.Role;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member extends BaseEntity {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String password;
	private String address;
	@Enumerated(EnumType.STRING)
	private Role role;
	

}
