package com.ravi.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String getMessage() {
		return "GOOD MORNING!!";	
	}
	
	public String getGreetMessage() {
		return "WELOCME GOOD MORNING!!";
	}
}
