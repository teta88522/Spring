package com.yedam.app.emp.service;

import java.util.Date;
import lombok.Data;

@Data
public class EmpVO {
	private Integer employee_id;
	private String last_name;
	private String email;
	private Date hire_date;
	private String job_id;

}
