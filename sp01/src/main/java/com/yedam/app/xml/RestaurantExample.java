package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestaurantExample {

	public static void main(String[] args) {
		System.out.println("Spring XML 방식 : DI");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("XmlApplicationContext.xml");
		
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
		
		// 세터 인젝션을 이용할 경우 아래 코드처럼 의도치않게 교체가능
		// 생성자 인젝션을 더 권장
		// => 생성자를 통해 DI 이후 Bean을 교체할 수 없음.
//		res.setChef(new Chef());
//		res.run();
	}

}
