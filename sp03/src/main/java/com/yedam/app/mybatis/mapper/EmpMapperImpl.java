package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.yedam.app.mybatis.service.EmpVO;

import lombok.RequiredArgsConstructor;

// Mapper의 구현 객체 => Mybatis가 자동 생성
@Repository
@RequiredArgsConstructor
public class EmpMapperImpl implements EmpMapper {
	// DAO 객체
	private final SqlSessionFactory factory;

	@Override
	public List<EmpVO> selectAll() {
		SqlSession session = factory.openSession();
		List<EmpVO> list = session.selectList("com.yedam.app.mybatis.mapper.EmpMapper.selectAll");
		session.close();
		return list;
	}

	@Override
	public EmpVO selectInfo(EmpVO emp) {
		// try-with=resources : 자동으로 자원을 닫아줌 단 closeable 상속 받을때만
		try (SqlSession session = factory.openSession()){
			EmpVO find = session.selectOne("com.yedam.app.mybatis.mapper.EmpMapper.selectInfo", emp);
			return find;
		}
		
	}

	@Override
	public int insertInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.insert("com.yedam.app.mybatis.mapper.EmpMapper.insertInfo", emp);
			return result;
		}
	}

	@Override
	public int updateInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.update("com.yedam.app.mybatis.mapper.EmpMapper.updateInfo", emp);
			return result;
		}
	}

	@Override
	public int deleteInfo(int empId) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.delete("com.yedam.app.mybatis.mapper.EmpMapper.deleteInfo", empId);
			return result;
		}
	}

}
