package com.jwt.tokensystem.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationFilterCreated extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationFilterCreated() {
		super("/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAuthManager(AuthenticationManager authenticationManager) {
		// TODO Auto-generated method stub
		
	}

	public void setStatusHandler(StatusHandler statusHandler) {
		// TODO Auto-generated method stub
		
	}



}
