package com.yedam.app.common.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller // Web(dispatcherSevlet)과 관련된 Bean
@RequiredArgsConstructor
public class EmpController {

	final private EmpService empService;

	// GET : 빈페이지, 조회
	// POST : 데이터 조작(등록, 수정, 삭제)
	// 삭제 => 경우에 따라 GET으로 처리함.

	// 전체조회 - GET
	@GetMapping("empList") // 1) EndPoint
	public String empList(Model model) {
		// 2) 제공할 서비스
		List<EmpVO> list = empService.findAll();
		// 3) 응답 형태를 선택
		// 3-1) 응답 형태를 선택 - view
		model.addAttribute("emps", list);
		// 3-2) 데이터를 출력할 페이지를 선택
		return "emp/list"; // prefix -> claspath : templates/ 때문에 '/'로 시작 x
					// suffix -> .html
	}

	// 단건조회 - GET

	@GetMapping("empInfo") // QueryString 1)커맨드객체 2)@RequestParams
				// 커맨드객체 : @ X , 객체타입
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}

	// 등록, 페이지 - GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}

	// 등록, 처리 - POST => <form/>
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		// empInfo?employeeId = 1000
		return "redirect:empInfo?employeeId=" + eid; // redirect는 새로운 컨트롤러 메소드를 호출
	}

	// 수정, 페이지 - GET
	@GetMapping("empUpdate")
	public String empUpdateFrom(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp",findVO);
		return "emp/update";
	}
	// 수정, 처리 - POST => Ajax, @ResponseBody
	@PostMapping("empUpdate")
		@ResponseBody         // AJAX용이라 페이지 없이 데이터만 반환
						     // => Return타입이 반환될 데이터를 반영
		public Map<String,Object> empUpdateProcess(@RequestBody EmpVO empVO){  // JSON형태로 받고 싶으면 RequestBody 추가
				return empService.modifyEmpInfo(empVO);
	}

	// 삭제, 처리 - GET => 보통은 단건 조회같은 조회 페이지에서 삭제 기능 같이 추가
	//  => QueryString => 기본타입형 => @RequestParam
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.removeEmpInfo(empId);
		return "redirect:empList";
	}

}
