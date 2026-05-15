package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
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
	void insertOne() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@gm");
		empVO.setSalary(1000);
		empVO.setJobId("IT_PROG");
		// 동적 쿼리 테스트
		empVO.setHireDate(new Date());
		int result = empMap.insertEmp(empVO);
                //assertEquals(1, result);
		assertEquals(302 , empVO.getEmployeeId());
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
	@Test
	@Transactional
	void deleteOne() {
		int result = empMap.deleteEmp(206);
	}
	
	@Test
	void search() {
		EmpVO search = new EmpVO();
		search.setJobId("IT");
		search.setManagerId(200);
		System.out.println("job_id와 manager_id ==");
		List<EmpVO> result = empMap.selectList(search);
		result.stream().forEach(System.out :: println);
		
		search = new EmpVO();
		search.setJobId("SA");
		System.out.println("job_id만 ==");
		result = empMap.selectList(search);
		result.stream().forEach(System.out::println);
		
		search = new EmpVO();
		search.setManagerId(178);
		System.out.println("manager_id만 == ");
		result = empMap.selectList(search);
		result.stream().forEach(System.out::println);
		
		System.out.println("조건이 없는 경우");
		result = empMap.selectList(new EmpVO());
		result.stream().forEach(System.out::println);
		
	}
	
	@Test
	void selectListByDept() {
		List<Integer> deptList = List.of(10,30,50);
		List<EmpVO> findList = empMap.selectListByDept(deptList);
		findList.stream().forEach(System.out::println);
		
	}
}
