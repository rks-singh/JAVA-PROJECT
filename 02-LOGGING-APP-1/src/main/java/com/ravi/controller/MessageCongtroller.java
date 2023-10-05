package com.ravi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageCongtroller {

	Logger logger = LoggerFactory.getLogger(MessageCongtroller.class);

	@GetMapping("/msg")
	public String getMessage() {

		logger.info("Welcome() method execution start....");

		String msg = "Welcome to First Spring Boot Application";

		logger.info("Welcome() method execution end.....");
		
		return msg;
	}

	@GetMapping("/greet")
	public String greetMessage() {
		
		logger.info("Greet() method execution start....");
		
		String msg = "Good Morning";
		
		logger.info("Greet() method execution end.....");
		
		return msg;
	}

}
