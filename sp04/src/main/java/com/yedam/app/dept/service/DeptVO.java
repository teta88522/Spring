package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	//-underscore-to-camel-case 설정으로 -> camel케이스로 표기 = db는 snake케이스 지만 자동변환해줌
	private Integer departmentId;  // PK
	private String departmentName;
	private int managerId;      
	private int locationId;  

}
