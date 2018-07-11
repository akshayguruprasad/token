package com.jwt.tokensystem.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.jwt.tokensystem.model.JwtToken;

public class JwtAuthenticationFilterCreated extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationFilterCreated() {
		super("/**");

		System.out.println("Hits the filter");

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		System.out.println("Attem to auth ");
		String headerData = request.getHeader("authentication");
		System.out.println(headerData + " is the data to be displayed in the header");

		if (headerData == null) {
			throw new RuntimeException("Failed to get header data");
		}
		String token = headerData.substring(6);
		JwtToken authToken = new JwtToken(token);
		return getAuthenticationManager().authenticate(authToken);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
}
