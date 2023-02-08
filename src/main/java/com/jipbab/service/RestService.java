package com.jipbab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jipbab.dto.RestaurantFormDto;
import com.jipbab.entity.ResImg;
import com.jipbab.entity.Restaurant;
import com.jipbab.repository.RestImgRepository;
import com.jipbab.repository.RestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RestService {
	private final RestRepository restRepository;
	private final RestImgService restImgService;

	public Long saveRestaurant(RestaurantFormDto restFormDto, List<MultipartFile> restImgFileList) throws Exception {
		Restaurant restaurant = restFormDto.createRest();
		restRepository.save(restaurant);

		for (int i = 0; i < restImgFileList.size(); i++) {
			ResImg resImg = new ResImg();
			resImg.setRestaurant(restaurant);
			
			//첫 번째 이미지 일때 대표 상품 이미지 여부 저장
			if(i == 0 ) {
				resImg.setRes_repimgYn("Y");
			}else {
				resImg.setRes_repimgYn("N");
			}
			restImgService.saveRestImg(resImg, restImgFileList.get(i));
		}
		return restaurant.getRes_id();
	}

}
