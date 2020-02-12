package com.fdmgroup.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.fdmgroup")
public class SpringConfig {
	
	@Bean
	public ViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver("WEB-INF/views/", ".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	 @Bean
	 public EntityManagerFactory entityManagerFactory() {
	 return Persistence.createEntityManagerFactory("Persistence");
	 }
	
	
}
