package com.jipbab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jipbab.service.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	MemberService memberService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.formLogin()
			.loginPage("/members/login") //로그인 페이지 url 설정
			.defaultSuccessUrl("/") //로그인 성공시 이동할 페이지
			.usernameParameter("email") //로그인시 사용할 파라메터 이름
			.failureUrl("/members/login/error") //로그인 실패시 이동할 url
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
			.logoutSuccessUrl("/"); //로그아웃 성공시 이동할 url
		
		//페이지의 접근에 관한 설정
		http.authorizeRequests()
			.mvcMatchers("/css/**", "/js/**", "/img/**").permitAll()
			.mvcMatchers("/","/members/**","/item/**","/images/**").permitAll()
			.mvcMatchers("/admin/**").hasRole("ADMIN") //'admin' 으로 시작하는 경로는 계정이 admin role일 경우에만 접근 가능하도록
			.anyRequest().authenticated(); //그 외에 페이지는 모두 로그인 (인증)을 받아야 한다.
		
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}