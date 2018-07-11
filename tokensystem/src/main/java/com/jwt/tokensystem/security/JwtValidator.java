package com.jwt.tokensystem.security;

import org.springframework.stereotype.Component;

import com.jwt.tokensystem.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	public JwtUser validate(String token) {

		Claims body = Jwts.parser().setSigningKey("welcome").parseClaimsJws(token).getBody();

		JwtUser user = null;
		try {

			user = new JwtUser();

			user.setName(body.getSubject());
			user.setId((String) body.get("userId"));
			user.setRole((String) body.get("role"));
		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}
		return user;
	}

}
