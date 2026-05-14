package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller // 라우팅정보를 가지는 방
@RequiredArgsConstructor
public class EmpController {
	private final EmpService empService;
	
//	router.get('/users',async(req,res) => {
//		let result = aswait userService.findAll();
//		res.send(result);
//	});
	
	@GetMapping("/empList")
	public String empList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps",list);
		return "empList";
	}

}
