package com.yedam.java.lombok;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
//@NoArgsConstructor
//@Data
public class Restaurant {
	// ==필드
	private final Chef chef; // 집합관계 : 객체가 다른객체에 하나의 정보로 들어가는것.
	//@Setter(onMethod_ = {@Autowired}) // Setter 주입방식
	//private Chef chef;

		public void run() {
			chef.cooking();
	}
}
