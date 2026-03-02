package com.example.filterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.filterdemo.filter.LoggingFilter;
import com.example.filterdemo.filter.SecondFilter;

@SpringBootApplication
public class FilterdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterdemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilter() {

		FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new LoggingFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1); // lower number = higher priority

		return registrationBean;

	}

	@Bean
	public FilterRegistrationBean<SecondFilter> secondfilter() {
		FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new SecondFilter());
		registrationBean.addUrlPatterns("/admin");
		registrationBean.setOrder(2);
		return registrationBean;

	}

}
