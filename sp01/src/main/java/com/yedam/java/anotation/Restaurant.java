package com.yedam.java.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	// ==필드
	private Chef chef; // 집합관계 : 객체가 다른객체에 하나의 정보로 들어가는것.
	
	// ==생성자
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// ==메소드
	public Restaurant() {}
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
