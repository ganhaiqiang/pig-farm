package com.ghq.pig.farm.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ghq.pig.farm.common.interceptor.SessionInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor()).excludePathPatterns("/login", "/logout", "/css/**", "/js/**", "/webjars/**", "/images/**", "/fonts/**", "/favicon.ico");
	}

}
