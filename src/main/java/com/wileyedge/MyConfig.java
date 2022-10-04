package com.wileyedge;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.*")
public class MyConfig {
	@Bean
	public DriverManagerDataSource getDS() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		System.out.println("Inside getDS");
		ds.setUrl("jdbc:mysql://localhost:3306/dvd");
		ds.setPassword("root");
		ds.setUsername("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	@Bean
	public JdbcTemplate getTemplate() {
		System.out.println("Inside getTemplate");
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDS());
		return template;
	}
}
