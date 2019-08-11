package com.example.pack.core.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String databaseDriver;

	@Value("${spring.datasource.url}")
	private String databaseUrl;

	@Value("${spring.datasource.username}")
	private String databaseUsername;

	@Value("${spring.datasource.password}")
	private String databasePassword;

	@Value("${spring.jpa.database-platform}")
	private String databasePlatform;

	@Value("${spring.jpa.generate-ddl}")
	private boolean isGenerateDDL;

	@Value("${spring.jpa.show-sql}")
	private boolean isShowSQL;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(isGenerateDDL);
		jpaVendorAdapter.setShowSql(isShowSQL);
		jpaVendorAdapter.setDatabasePlatform(databasePlatform);
		return jpaVendorAdapter;
	}
}