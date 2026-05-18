package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller // Web과 관련된 Bean
@RequiredArgsConstructor
public class DeptController {
	
	final private DeptService deptSer;
	
	// 전체조회 - GET
	@GetMapping("deptList")
	public String empList(Model model) {
		// 2) 제공할 서비스
		List<DeptVO> list = deptSer.findAll();
		// 3) 응답 형태를 선택
		// 3-1) 응답 형태를 선택 - view
		model.addAttribute("emps", list);
		// 3-2) 데이터를 출력할 페이지를 선택
		return "dept/list"; // prefix -> claspath : templates/ 때문에 '/'로 시작 x
						// suffix -> .html
	}
	
	// 단건조회 - GET

	@GetMapping("deptInfo") // QueryString 1)커맨드객체 2)@RequestParams
				// 커맨드객체 : @ X , 객체타입
	public String empInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptSer.findByDeptId(deptVO);
		model.addAttribute("deptId", findVO);
		return "dept/info";
	}
}
