package com.ravi.jwt.security;

import io.jsonwebtoken.Claims;

public class JWT_Test {

	private static final String SECRET_KEY = "J@!gt*K";
	
	public static void main(String[] args) {
		
		//Code to test generated token.
		String tocken = JWTUtil.generateTocken("Token1", SECRET_KEY);
		
		System.out.println("-------------------- TOKEN --------------------");
		System.out.println(tocken);
		System.out.println();
		System.out.println("-------------------- CLAIMS --------------------");
		
		//Code to test parsed token : claims
		Claims claims = JWTUtil.getClaims(tocken, SECRET_KEY);
		System.out.println("Token ID :: "+claims.getId());
		System.out.println("Token Subject :: "+claims.getSubject());
		System.out.println("Token Issuer :: "+claims.getIssuer());
		System.out.println("Token Issue Date :: "+claims.getIssuedAt());
		System.out.println("Token Expiration Date :: "+claims.getExpiration());
		System.out.println("Token Audience :: "+claims.getAudience());
	}

}
