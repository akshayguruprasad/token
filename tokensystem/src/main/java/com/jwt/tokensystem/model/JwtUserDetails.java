package com.jwt.tokensystem.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String name;
String id;
JwtToken token;
List<GrantedAuthority> x;
	


	public String getName() {
	return name;
}

public String getId() {
	return id;
}

public JwtToken getToken() {
	return token;
}

public List<GrantedAuthority> getX() {
	return x;
}


	public JwtUserDetails(String name, String id, JwtToken token, List<GrantedAuthority> x) {
	super();
	this.name = name;
	this.id = id;
	this.token = token;
	this.x = x;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
