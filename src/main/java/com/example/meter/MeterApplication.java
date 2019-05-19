package com.example.meter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MeterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MeterApplication.class, args);
	}

}
