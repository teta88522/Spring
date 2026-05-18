package com.yedam.app.common.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

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

	// 등록, 페이지 - GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}

	// 등록, 처리 - POST => <form/>
	@PostMapping("deptInsert")
	public String empInsertProcess(DeptVO deptVO) {
		int did = deptSer.addDeptInfo(deptVO);
		return "redirect:deptInfo?departmentId =" + did; // redirect는 새로운 컨트롤러 메소드를 호출
	}

	// 수정, 페이지 - GET
	@GetMapping("deptUpdate")
	public String empUpdateFrom(DeptVO deptVO, Model model) {
		DeptVO findVO = deptSer.findByDeptId(deptVO);
		model.addAttribute("dept",findVO);
		return "dept/update";
	}

	// 수정, 처리 - POST => Ajax, @ResponseBody
	@PostMapping("deptUpdate")
		@ResponseBody         // AJAX용이라 페이지 없이 데이터만 반환
						     // => Return타입이 반환될 데이터를 반영
		public Map<String,Object> deptUpdateProcess(@RequestBody DeptVO deptVO){  // JSON형태로 받고 싶으면 RequestBody 추가
				return deptSer.modifyDeptInfo(deptVO);
	}
}
