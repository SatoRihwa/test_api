package com.example.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.logger.controller.LoggerController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.logger.bean"})
@ComponentScan(basePackageClasses = LoggerController.class)
public class LoggerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerRestApplication.class, args);
	}

}
