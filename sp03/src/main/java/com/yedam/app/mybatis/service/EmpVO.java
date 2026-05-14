package com.yedam.app.mybatis.service;

// typeHandler = DateTypeHandler
import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	// mapUnderScoreToCamelCase : true
	//employee_id => employeeId
	private Integer employeeId;
	// first_name => firstName
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	

}
