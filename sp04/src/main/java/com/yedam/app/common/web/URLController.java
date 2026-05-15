package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 주의) 모든 클래스는 어떤 형태로든 어노테이션이 붙음
// 그러므로 class를 작성할 떄 어떤 Annotation이 붙을지 먼저 생각
@Controller // Web(dispatcherServelt)과 관련된 Bean 등록
		    // Route = Endpoint(HTTP Method + URI)
		    //  		+ Service
		   //  		+ Return Type(View or Data)
public class URLController {
	
	//@RequestMapping(path = "/getKeyword", method=RequestMethod.GET)
	@GetMapping("/getKeyword")
	@ResponseBody // AJAX
	public String getMapping(String keyword) {
		return "Get Method : keyword, " + keyword;
	}
	
	//@RequestMapping(path = "/postKeyword", method=RequestMethod.Post)
	@PostMapping("/postKeyword")
	@ResponseBody // AJAX
	public String postMapping(String keyword) {
		return "Post Method : keyword, " + keyword;
	}

}
