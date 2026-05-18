package com.yedam.app.dept.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Service // 비지니스 영역 + 트랙잭션 처리
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

	final private DeptMapper deptMap;

	@Override
	public List<DeptVO> findAll() {
		return deptMap.selectDeptAll();
	}

	@Override
	public DeptVO findByDeptId(DeptVO deptVO) {
		return deptMap.selectDept(deptVO);
	}

	@Override
	public int addDeptInfo(DeptVO deptVO) {
		int result = deptMap.insertDept(deptVO);
		// <selectKey/> 사용으로 가능함
		return result > 0 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = deptMap.updateDept(deptVO);
		if (result >= 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		/*
		 * { "result" : true, "target" : { "employeeId" : 100, "lastName" : "King", ...
		 * } }
		 */
		return map;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int deptId) {
		Map<String, Object> map = new HashMap<>();
		// => map의 변수 : {}
		int result = deptMap.deleteDept(deptId);
		if (result >= 1) {
			map.put("employeeId", deptId);
			// => { "employeeId" : 100}
		}
		return map;
	}

}
