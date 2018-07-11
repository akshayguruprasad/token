package com.jwt.tokensystem;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class UserCredentials {

	
	
	
	public String generator() {
		Claims claim=Jwts.claims();
		claim.setSubject("Welcome");
		return Jwts.builder().setClaims(claim).compact();
		
	}
	
	
	
	
	
}
