package com.yedam.app.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Java-based Configuration
@Configuration // 해당 클래스는 설정정보를 들오있음을 표시.
public class JavaConfig {
	
	@Bean // 해당 메소드가 반환한 인스턴스를 Bean으로 등록할때 사용 (주최는 IoC Container)
	public Chef chef() {
		return new Chef();
	}
	
	@Bean(name = "res")
	public Restaurant restaurant(Chef chef) {
		// Setter 방식
//		Restaurant res = new Restaurant();
//		res.setChef(chef);
//		return res;
		// 생성자
		return new Restaurant(chef);
	}
}
