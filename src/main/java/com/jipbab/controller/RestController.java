package com.jipbab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jipbab.dto.RestaurantFormDto;
import com.jipbab.service.RestService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/restaurant")
@Controller
@RequiredArgsConstructor
public class RestController {
	private final RestService restService;
	
	@GetMapping(value="/myrest")
	public String restMy() {
		return "restaurant/restMy";
	}
	@GetMapping(value="/myreply")
	public String restReply() {
		return "restaurant/restReply";
	}
	
	//음식점 등록 페이지 보여주기
	@GetMapping(value="/myrestupload")
	public String restUpload(Model model) {
		model.addAttribute("restaurantFormDto",new RestaurantFormDto());
		return "restaurant/restUpload";
	}
	//음식점 등록 
	@PostMapping(value="/myrestupload")
	public String restNew(@Valid RestaurantFormDto restaurantFormDto, BindingResult bindingResult, Model model, @RequestParam("restImgFile") List<MultipartFile> restImgFileList ) {
		if(bindingResult.hasErrors()) {
			return "restaurant/restUpload";
		}
		//첫번째 이미지 검사
		if(restImgFileList.get(0).isEmpty() && restaurantFormDto.getRes_id() == null) {
			model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값입니다.");
			return "restaurant/restUpload";
		}
		try {
			restService.saveRestaurant(restaurantFormDto, restImgFileList);
		}catch(Exception e) {
			model.addAttribute("errorMessage", "상품 등록 중 에러가 발생했습니다.");
			return "rest/restUpload";
		}
		return "redirect:/";
	}
	
	@GetMapping(value="/restaurant")
	public String showRest() {
		return "restaurant/restaurant";
	}
	
}
