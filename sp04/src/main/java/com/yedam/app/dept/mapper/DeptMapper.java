package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.dept.service.DeptVO;

@Mapper  //  Application 에서 추가해서 따로 쓸 필요는 없음
public interface DeptMapper {

	// 조건없는 다건조회
	public List<DeptVO> selectDeptAll();

	// 결과가 하나인 단건조회
	public DeptVO selectDept(DeptVO dept);

	// 등록
	public int insertDept(DeptVO dept);

	// 수정
	public int updateDept(DeptVO dept);

	// 삭제
	public int deleteDept(int deptId);

}
