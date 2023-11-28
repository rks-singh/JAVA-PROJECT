package com.ravi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/message")
	public String getMessage() {
		System.out.println("Request Recive!!");
		return "WELCOME TO SPRINGBOOT PERFORMANCE TESTING APP";
	}
}
