package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.common.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ParameterController {
	//  QueryString(질의문자열)
	//  format : key=value&key=value&...
	// Content-type : application/x-www-form-urlencoded
	// http Method : 전부 가능
	
	// => 1) 커맨드 객체  : @ 없음. 객체타입
	
	@RequestMapping("/comobj")
	@ResponseBody
	public String commandObject(UserVO user) {
		log.info("path : /comobj");
		log.info("= name :  " + user.getName() );
		log.info("= age :  " + user.getAge());
		log.info("UserVO  :  " + "name :  " + user.getName() + "age :  " + user.getAge());
		return "success";
	}
	
	// => 2) @RequestParam : @ 존재 (default). 기본 데이터형(단일값)

}
