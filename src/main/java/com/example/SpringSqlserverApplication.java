package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages="your.package", entityManagerFactoryRef="emf")
public class SpringSqlserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSqlserverApplication.class, args);
	}

}
