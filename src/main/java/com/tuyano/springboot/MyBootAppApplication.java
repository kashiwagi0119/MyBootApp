package com.tuyano.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

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
//	  vendorAdapter.setShowSql(true);
//	  return vendorAdapter;
//	}
//	
//   @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(dataSource());
//      em.setPackagesToScan("com.tuyano.springboot");
//
//
//      em.setJpaVendorAdapter(jpaVenderAdapter());
//      
//      Map<String, Object> properties = new HashMap<>();
////      properties.put("hibernate.ejb.naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy");
////      properties.put("hibernate.ejb.naming_strategy", "SuffixNamingStrategy");
////      properties.put("spring.jpa.hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
////      properties.put("spring.jpa.hibernate.naming.implicit-strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
//      properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
////      properties.put("spring.jpa.hibernate.naming.physical-strategy", "TestNamingStrategy");
////      properties.put("hibernate.ejb.naming_strategy", "org.hibe1rnate.cfg.EJB3NamingStrategy");
//      em.setJpaPropertyMap(properties);
//      em.afterPropertiesSet();
//     
//      
//      return em;
//   }
// 
//   @Bean(destroyMethod = "close")
//   public DataSource dataSource(){
//      BasicDataSource dataSource = new BasicDataSource();
//      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	  dataSource.setUrl("jdbc:mysql://localhost:3306/taka1?characterEncoding=UTF-8");
//	  dataSource.setUsername("root");
//	  dataSource.setPassword("0422");
//      return dataSource;
//   }
	   
}
