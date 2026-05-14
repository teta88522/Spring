package com.yedam.java.anotation;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking() {
		System.out.println("요리를 합니다.");
	}
}
