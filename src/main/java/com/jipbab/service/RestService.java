package com.jipbab.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jipbab.dto.MainRestDto;
import com.jipbab.dto.ResImgDto;
import com.jipbab.dto.RestSearchDto;
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
	private final RestImgRepository restImgRepository;

	public Long saveRestaurant(RestaurantFormDto restFormDto, List<MultipartFile> restImgFileList) throws Exception {
		Restaurant restaurant = restFormDto.createRest();

		restRepository.save(restaurant);

		for (int i = 0; i < restImgFileList.size(); i++) {
			ResImg resImg = new ResImg();
			resImg.setRestaurant(restaurant);

			// 첫 번째 이미지 일때 대표 상품 이미지 여부 저장
			if (i == 0) {
				resImg.setResRepimgYn("Y");
			} else {
				resImg.setResRepimgYn("N");
			}
			restImgService.saveRestImg(resImg, restImgFileList.get(i));
		}

		return restaurant.getId();
	}

	@Transactional(readOnly = true)
	public Page<Restaurant> getAdminRestPage(RestSearchDto restSearchDto, Pageable pageable) {
		return restRepository.getAdminRestPage(restSearchDto, pageable);
	}

	// 상품가져오기
	@Transactional(readOnly =  true)
	public RestaurantFormDto getRestDtl(Long resId) {
		//1. res_img 테이블의 이미지를 가져온다.
		List<ResImg> resImgList = restImgRepository.findByRestaurantIdOrderByIdAsc(resId);
		List<ResImgDto> resImgDtoList = new ArrayList<>();
			
		//엔티티 객체 -> dto 객체로 변환
		for (ResImg resImg : resImgList) {
			ResImgDto resImgDto = ResImgDto.of(resImg);
			resImgDtoList.add(resImgDto);
		}
		Restaurant restaurant = restRepository.findById(resId).orElseThrow(EntityNotFoundException::new);
		
		RestaurantFormDto restaurantFormDto = RestaurantFormDto.of(restaurant);
		
		restaurantFormDto.setResImgDtoList(resImgDtoList);
		
		return restaurantFormDto;
	}
	
	//상품 수정
	public Long updateRest(RestaurantFormDto restaurantFormDto, List<MultipartFile> restImgFileList) throws Exception	{
		
		Restaurant restaurant = restRepository.findById(restaurantFormDto.getId()).orElseThrow(EntityNotFoundException::new);
		
		restaurant.updateRest(restaurantFormDto);
		
		List<Long>resImgIds = restaurantFormDto.getResImgIds();
		
		for(int i = 0 ; i< restImgFileList.size(); i++) {
			restImgService.updateResImg(resImgIds.get(i), restImgFileList.get(i));
		}
		return restaurant.getId();
				
	}
	
	
	
	
	
	
	

	public Page<MainRestDto> getMainRestPage(RestSearchDto restSearchDto, Pageable pageable) {
		return restRepository.getMainRestPage(restSearchDto, pageable);
	}
}
