package com.tuyano.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
public class MyBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootAppApplication.class, args);
	}
	
//	@Bean
//	public JpaVendorAdapter jpaVenderAdapter() {
//	  HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	  vendorAdapter.setDatabase(Database.MYSQL);
////	  vendorAdapter.setDatabase(Database.ORACLE);
//	  vendorAdapter.setShowSql(true);
//	  return vendorAdapter;
//	}
//	
//   @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(dataSource());
//      em.setPackagesToScan("com.tuyano.springboot");
//      em.setJpaVendorAdapter(jpaVenderAdapter());
//      Map<String, Object> properties = new HashMap<>();
//      properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy"); // ネーミングルールを適用
////    不要っぽい  properties.put("hibernate.connection.handling_mode", "DELAYED_ACQUISITION_AND_HOLD");
//      properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
////    →ORACLEに変更する  properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//      properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
//      properties.put("hibernate.show_sql", "true");
//      em.setJpaPropertyMap(properties);
//      em.afterPropertiesSet();
//      
//      return em;
//   }
// 
//   @Bean
//   public DataSource dataSource(){
//      BasicDataSource dataSource = new BasicDataSource();
//      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	  dataSource.setUrl("jdbc:mysql://localhost:3306/taka1?characterEncoding=UTF-8");
//	  dataSource.setUsername("root");
//	  dataSource.setPassword("0422");
//      return dataSource;
//   }
	   
}
