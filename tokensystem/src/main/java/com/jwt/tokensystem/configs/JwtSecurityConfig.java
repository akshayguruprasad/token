package com.jwt.tokensystem.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.tokensystem.security.JwtAutenticationEntryPoint;
import com.jwt.tokensystem.security.JwtAuthenticationFilterCreated;
import com.jwt.tokensystem.security.JwtAuthenticationProvider;
import com.jwt.tokensystem.security.StatusHandler;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	private JwtAuthenticationProvider authenticationProvider;
private JwtAutenticationEntryPoint authenticateEntryPoint;
	public AuthenticationManager getAuthenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Bean
	public JwtAuthenticationFilterCreated getAuthenticationFilter() {
		JwtAuthenticationFilterCreated filter = new JwtAuthenticationFilterCreated();
		filter.setAuthManager(getAuthenticationManager());
		filter.setStatusHandler(new StatusHandler());
		return filter;
	}

@Override
protected void configure(HttpSecurity http) throws Exception {

http.csrf().disable().antMatcher("**/rest/**").authorizeRequests().and().exceptionHandling().authenticationEntryPoint(authenticateEntryPoint).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterAfter(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
http.headers().cacheControl();



}

	

}
