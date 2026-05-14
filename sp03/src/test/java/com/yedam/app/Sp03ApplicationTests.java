package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.service.EmpVO;

@SpringBootTest  // AutoCommit기반
class Sp03ApplicationTests {
	@Autowired // 필드 주입
	private EmpMapper empMap; 
//	@Test
	void selectAll() {
		List<EmpVO> list = empMap.selectAll();
		// assertXXX 메소드 : 결과를 단정짓는 메소드
		assertTrue(!list.isEmpty());
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
	}
//	@Test
	void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(100);
		
		EmpVO findVO = empMap.selectInfo(emp);
		//                       예상결과, 실제결과
		assertEquals("KING",findVO.getLastName());
		
	}
	
	@Test
	void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@gmail.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMap.insertInfo(empVO);
		assertEquals(1, result);
	}
	
//	@Test
	void updateInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(206);
		emp.setFirstName("Adward");
		emp.setSalary(8900);
		
		int result = empMap.updateInfo(emp);
		assertEquals(1, result);
	}
	
//	@Test
	void deleteInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(206);
		
		int result = empMap.deleteInfo(emp.getEmployeeId());
		assertEquals(1, result);
	}

}
