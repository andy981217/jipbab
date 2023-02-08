package com.jipbab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jipbab.entity.ResImg;


public interface RestImgRepository extends JpaRepository<ResImg, Long>{
//	List<ResImg> findByRes_img_id(Long res_img_id);
}
