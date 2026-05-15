package com.yedam.app.common.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserVO {
	private String name;
	private Integer age;

}
