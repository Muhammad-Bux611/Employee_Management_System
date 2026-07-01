package com.erp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.erp.security.JwtSecurityFilter;
import com.erp.security.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class GlobalConfiguration {
	
	@Autowired
	UserDetailServiceImpl detailServiceImpl;
	@Autowired
	JwtSecurityFilter filter;
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) {
		http
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth.requestMatchers("/api/auth/register","/api/auth/login").permitAll()
				
				.requestMatchers(HttpMethod.GET,"/api/employee/**").hasAnyRole("ADMIN","EMPLOYEE")
				.requestMatchers("/api/employee/**","/api/auth/**","/api/departments/**").hasRole("ADMIN")
				
				)
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
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
