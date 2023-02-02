package com.jipbab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import lombok.RequiredArgsConstructor;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
	@GetMapping(value = "/login")
	public String loginMember() {
		return "member/memberLoginForm";
	}
	@GetMapping(value="/new")
	public String memberForm() {
		return "member/memberForm";
	}

}
