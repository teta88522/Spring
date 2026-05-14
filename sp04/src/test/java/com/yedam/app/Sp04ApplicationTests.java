package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Sp04ApplicationTests {

	@Autowired
	private EmpMapper empMap;

	@Test
	void contextLoads() {
		List<EmpVO> list = empMap.selectEmpAll();
		assertTrue(!list.isEmpty());
	}

//	@Test
	void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(100);

		EmpVO findVO = empMap.selectEmp(emp);
		// 예상결과, 실제결과
		assertEquals("KING", findVO.getLastName());

	}
	
	@Test
	@Transactional
	void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@gm");
		empVO.setSalary(1000);
		empVO.setJobId("IT_PROG");
		
		int result = empMap.insertEmp(empVO);
		assertEquals(1, result);
	}
	@Test
	void updateOne() {
		// 1) 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(206);
		EmpVO findVO = empMap.selectEmp(empVO);
		
		// 2) 수정정보 포함
		findVO.setLastName("Grek");
		findVO.setSalary(8300);
		
		// 3) DB 업데이트
		int result = empMap.updateEmp(findVO);
		assertEquals(1, result);
	}
	
	void deleteOnt() {
		int result = empMap.deleteEmp(206);
		
	}
}
