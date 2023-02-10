package com.jipbab.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.jipbab.dto.RestSearchDto;
import com.jipbab.dto.RestaurantFormDto;
import com.jipbab.entity.Restaurant;
import com.jipbab.service.RestService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/restaurant")
@Controller
@RequiredArgsConstructor
public class RestController {
	private final RestService restService;

	@GetMapping(value = "/myrest")
	public String restMy() {
		return "restaurant/restMy";
	}

	@GetMapping(value = "/myreply")
	public String restReply() {
		return "restaurant/restReply";
	}

	// 음식점 목록 보여주는 페이지
	@GetMapping(value = { "/check", "/check/{page}" }) // 페이지 번호가 없는 경우와 있는 경우 2가지를 매핑
	public String restCheck(RestSearchDto restSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
		// url 경로에 페이지가 있으면 해당 페이지를 조회하도록 하고 페이지 번호가 없으면 0페이지를 조회하도록 한다.
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
		// of(조회할 페이지 번호, 한페이당 조회할 데이터 갯수)
		Page<Restaurant> restaurants = restService.getAdminRestPage(restSearchDto, pageable);
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("restaurantFormDto", restSearchDto);
		model.addAttribute("maxPage", 5);

		return "restaurant/restCheck";
	}

	// 음식점 등록 페이지 보여주기
	@GetMapping(value = "/myrestupload")
	public String restUpload(Model model) {
		model.addAttribute("restaurantFormDto", new RestaurantFormDto());
		return "restaurant/restUpload";
	}

	// 음식점 등록
	@PostMapping(value = "/myrestupload")
	public String restNew(@Valid RestaurantFormDto restaurantFormDto, BindingResult bindingResult, Model model,
			@RequestParam("restImgFile") List<MultipartFile> restImgFileList) {
		if (bindingResult.hasErrors()) {
			return "restaurant/restUpload";
		}
		// 첫번째 이미지 검사
		if (restImgFileList.get(0).isEmpty() && restaurantFormDto.getId() == null) {
			model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값입니다.");
			return "restaurant/restUpload";
		}
		try {
			restService.saveRestaurant(restaurantFormDto, restImgFileList);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품 등록 중 에러가 발생했습니다.");
			return "restaurant/restUpload";
		}
		return "redirect:/";
	}

	@GetMapping(value = "/restaurant")
	public String showRest() {
		return "restaurant/restaurant";
	}
	
	@GetMapping(value="/myrestupload{resId}")
	public String restDtl(@PathVariable("resId")Long resId, Model model) {
		try {
			RestaurantFormDto restaurantFormDto = restService.getRestDtl(resId);
			model.addAttribute(restaurantFormDto);
		}catch(EntityNotFoundException e){
			model.addAttribute("errorMessage","존재하지 않는 음식점입니다.");
			model.addAttribute("restaurantFormDto",new RestaurantFormDto());
			return "restaurant/restUpload";
		}
		return "restaurant/restUpload";
	}

}
