package com.yedam.app.dept.service.Impl;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
