package com.example.userservice;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	@Qualifier("attachment")
//	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
	@Qualifier("department")
	@LoadBalanced
	public RestTemplate restTemplateDepartment(){
		return new RestTemplate();
	}
}
