package com.example.filterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.filterdemo.filter.LoggingFilter;

@SpringBootApplication
public class FilterdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterdemoApplication.class, args);
	}

	@Bean
	public LoggingFilter loggingFilter() {
		return new LoggingFilter();
	}
}


