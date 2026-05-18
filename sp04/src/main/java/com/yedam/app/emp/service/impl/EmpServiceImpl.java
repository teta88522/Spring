package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Service // 비지니스 영역에 해당하는 Bean 등록
		// 트랜잭션 처리
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	final private EmpMapper empMapper;

	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO findByEmployeeId(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int addEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);
		// <selectKey/> 사용으로 가능함
		return result > 0 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = empMapper.updateEmp(empVO);
		if (result >= 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		 * { "result" : true, "target" : { "employeeId" : 100, "lastName" : "King", ...
		 * } }
		 */
		return map;
	}

	@Override
	public Map<String, Object> removeEmpInfo(int empId) {
		Map<String, Object> map = new HashMap<>();
		// => map의 변수 : {}
		int result = empMapper.deleteEmp(empId);
		if (result >= 1) {
			map.put("employeeId", empId);
			// => { "employeeId" : 100}
		}
		return map;
	}

}
