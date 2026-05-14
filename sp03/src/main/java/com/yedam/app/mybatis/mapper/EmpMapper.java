package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.EmpVO;

//Mapper : 실제 SQL문을 수행하는 객체
	// 테이블 1 <-> Mapper 1
public interface EmpMapper {
	
	// 전체조회
	public List<EmpVO> selectAll();  // => PreparedStatement
	// 단건조회
	public EmpVO selectInfo(EmpVO emp);
	// 등록
	public int insertInfo(EmpVO emp);
	// 수정
	public int updateInfo(EmpVO emp);
	// 삭제
	public int deleteInfo(int empId);
	

}
