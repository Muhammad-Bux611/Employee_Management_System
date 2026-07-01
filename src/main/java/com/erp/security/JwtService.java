package com.erp.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	
	@Value("${jwt.secret}")
	private String secretKey;
	@Value("${jwt.expiration}")
	private long expiration;
	
	
	public Key getKey() {
		return Keys.hmacShaKeyFor(secretKey.getBytes());
	}
	
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(getKey())
				.compact();
	}
	
	public String extractusername(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey) getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean isTokenValid(String token , UserDetails details) {
		String username= extractusername(token);
		
		return username.equals(details.getUsername());
	}

}
