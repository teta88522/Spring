package com.yedam.app.common;

public class Restaurant {
	// ==필드
	private Chef chef; // 집합관계 : 객체가 다른객체에 하나의 정보로 들어가는것.
	
	// ==생성자
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// ==메소드
	public Restaurant() {}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
}
