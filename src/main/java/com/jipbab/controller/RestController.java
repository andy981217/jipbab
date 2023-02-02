package com.jipbab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
@RequestMapping("/restaurant")
@Controller
@RequiredArgsConstructor
public class RestController {
	@GetMapping(value="/myrest")
	public String restMy() {
		return "restaurant/restMy";
	}
	@GetMapping(value="/myreply")
	public String restReply() {
		return "restaurant/restReply";
	}
	@GetMapping(value="/myrestupload")
	public String restUpload() {
		return "restaurant/restUpload";
	}
}
