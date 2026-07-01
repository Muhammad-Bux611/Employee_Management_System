package com.erp.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class JwtSecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtService jwtService;
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		 
		if (header==null || !header.startsWith("Bearer ")) {
		 filterChain.doFilter(request, response);

			return;
		}
		String token = header.substring(7);
		String username = jwtService.extractusername(token);
		
		if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails details = userDetailsService.loadUserByUsername(username);
			if (jwtService.isTokenValid(token, details)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details,null,details.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

	
	
}
