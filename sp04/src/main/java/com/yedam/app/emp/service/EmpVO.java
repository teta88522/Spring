package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	// DB와 연결 -> 컬럼명을 참고해서 필드명 구성 
	private Integer employeeId;    // PK
	private String firstName;
	private String lastName; 	    // Not Null
	private String email;		   // Not Null, Unique
	private String phoneNumber;
	private Date hireDate;		 // Not Null
	private String jobId;		// Not Null , FK(jobs)
	private double salary;
	private double commissionPct; // 1>value
	private int managerId;		// FK(employees)
	private int departmentId;	// FK(departments)
	

}
