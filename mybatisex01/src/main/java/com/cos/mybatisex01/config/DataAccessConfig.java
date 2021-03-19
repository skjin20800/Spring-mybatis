package com.cos.mybatisex01.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DataAccessConfig {
	
	//SqlSession을 만들기 위한 공장 생성// 연결과 인증이 끝난객체,
	//1.DataSource 등록 =>yml에서 만들어진 것을 가져옴.
	//2.xml 파일 연결
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*.xml"));
		return sessionFactoryBean.getObject();
	}

	//SqlSession 만들기
	//1.sqlSession은 인터페이스여서 직접 만들면 번거롭기 때문에 SqlSessionTemplate 사용 (편함)
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
//		SqlSessionTemplate s = new SqlSessionTemplate(sqlSessionFactory);
//		s.select(SQL문 작성 .xml파일 이용, 파라미터, 핸들러);
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}


