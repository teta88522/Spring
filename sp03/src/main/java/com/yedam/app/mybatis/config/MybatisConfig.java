package com.yedam.app.mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
	
	@Bean  // SqlSessionFactory : DAO 역할을 해줄 클래스 
	SqlSessionFactory sqlSessionFactory() throws Exception{
		// mybatis-config.xml 파일을 직접 읽어들임
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

}
