package com.jwt.token.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.tokensystem.UserCredentials;

@RestController
@RequestMapping("/rest")
public class UserController {

	UserCredentials credentials;

	@GetMapping("/generate")
	public String getCredentials() {
		System.out.println("Hits the controller ");
		return credentials.generator();

	}

	@GetMapping("/wel")
	public String data() {

		return "Wl";

	}

}
