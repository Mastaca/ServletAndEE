package com.fdm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.fdm")
public class MvcConfig extends WebMvcConfigurerAdapter{
	
//	@Bean
//	public InternalResourceViewResolver viewResolver () {
//		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//		internalResourceViewResolver.setPrefix("/WEB-INF/");
//		internalResourceViewResolver.setSuffix(".jsp");
//		return internalResourceViewResolver;
//	}
	
}
