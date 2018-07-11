package com.jwt.tokensystem.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jwt.tokensystem.model.JwtToken;
import com.jwt.tokensystem.model.JwtUser;
import com.jwt.tokensystem.model.JwtUserDetails;
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	JwtValidator validator;

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtToken.class.isAssignableFrom(authentication));

	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		JwtToken token = (JwtToken) authentication;
		String stringToken = token.getToken();

		JwtUser user = validator.validate(stringToken);

		if (user == null) {

			throw new RuntimeException("Failed to get the user");

		}

		List<GrantedAuthority> x = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		return new JwtUserDetails(user.getName(), user.getId(), token, x);
	}

}
