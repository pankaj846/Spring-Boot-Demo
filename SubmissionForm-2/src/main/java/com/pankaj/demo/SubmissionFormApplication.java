package com.pankaj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SubmissionFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubmissionFormApplication.class, args);
	}
}
