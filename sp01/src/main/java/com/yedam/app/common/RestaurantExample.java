package com.yedam.app.common;

public class RestaurantExample {

	public static void main(String[] args) {
		System.out.println("일반적인 방식 : DI");
		
		// 생성자
		Restaurant res = new Restaurant(new Chef());
		res.run();
		
		//세터
		Restaurant sec = new Restaurant();
		res.setChef(new Chef());
		sec.run();
	}

}
