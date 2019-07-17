package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication1Application.class, args);
	}

}
