package com.ravi.jwt.security;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	// code to generate token.
	public static String generateTocken(String subject, String secret_key) {
		
		String compact = Jwts.builder()
			.setId("tk9000")
			.setSubject(subject)
			.setIssuer("abc.com")
			.setAudience("xyz.com")
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.HOURS.toMillis(1)))
			.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret_key.getBytes()))
			.compact();
		return compact;
	}
	
	//Code to get Claims.
	public static Claims getClaims(String token, String secret_key) {
		Claims body = Jwts.parser()
			.setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
			.parseClaimsJws(token)
			.getBody();
		return body;
	}
}
