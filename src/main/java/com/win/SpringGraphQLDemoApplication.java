package com.win;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class SpringGraphQLDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQLDemoApplication.class, args);
	}

}
