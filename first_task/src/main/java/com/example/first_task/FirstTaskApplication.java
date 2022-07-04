package com.example.first_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FirstTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstTaskApplication.class, args);
	}

}
