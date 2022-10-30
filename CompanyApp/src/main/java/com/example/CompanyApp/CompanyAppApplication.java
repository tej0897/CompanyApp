package com.example.CompanyApp;

import com.example.CompanyApp.JwtFilter.SecurityFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompanyAppApplication {

	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean obj = new FilterRegistrationBean();
		obj.setFilter(new SecurityFilter());
		obj.addUrlPatterns("/api/v1/*");
		return obj;
	}

	public static void main(String[] args) {
		SpringApplication.run(CompanyAppApplication.class, args);
	}

}
