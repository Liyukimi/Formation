package com.objis.spring.demodatabase.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfig
{
	/* Correspondances avec le fichier db.properties */
	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.driver}")
	private String driverClassName;

	/*
	 * Bean de type DataSource Utilisé pour l'autowire (byType) avec EmployeDao
	 */
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);

		return dataSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

}
