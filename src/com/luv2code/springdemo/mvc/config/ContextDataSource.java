package com.luv2code.springdemo.mvc.config;
import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.transaction.annotation.EnableTransactionManagement;



/**

 * 데이터베이스 설정

 */

@Configuration

// 아노 테이션 기반 트랜잭션 관리를 사용 합니다.

// <tx:annotation-driven>

@EnableTransactionManagement

public class ContextDataSource {


	@Autowired
	private ApplicationContext applicationContext;
    /**

     * 데이터소스 등록

	 * @return

	 */

	@Bean(destroyMethod="close")
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		dataSource.setUrl("jdbc:mysql://34.84.140.112:3306/mysql?serverTimezone=UTC");

		dataSource.setUsername("yang");

		dataSource.setPassword("1235");

		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.
				getResources("classpath:/mapper/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}



	/**

	 * 트랜잭션 매니저 등록

	 * @return

	 */

    @Bean

    public DataSourceTransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());

    }

}