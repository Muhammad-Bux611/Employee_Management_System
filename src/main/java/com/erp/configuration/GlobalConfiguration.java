package com.erp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.erp.security.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class GlobalConfiguration {
	
	@Autowired
	UserDetailServiceImpl detailServiceImpl;
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) {
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth.anyRequest().permitAll());
	
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
		
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider provider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(detailServiceImpl);
		authenticationProvider.setPasswordEncoder(encoder());
		
		return authenticationProvider;
	}

}
