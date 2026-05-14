package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.EmpVO;

@Mapper // 임시
public interface EmpMapper {
	public List<EmpVO> selectAll();

}
