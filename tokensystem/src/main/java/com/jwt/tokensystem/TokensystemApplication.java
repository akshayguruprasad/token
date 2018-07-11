package com.jwt.tokensystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.jwt.token.system.controller"})
public class TokensystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokensystemApplication.class, args);
	}
}
