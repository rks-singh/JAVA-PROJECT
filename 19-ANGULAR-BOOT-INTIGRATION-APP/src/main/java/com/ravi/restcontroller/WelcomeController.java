package com.ravi.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WelcomeController {

	
	@GetMapping("/welcome-msg")
	public String getWellcomeMessage() {
		System.out.println("getWelcomeMessage() method called..");
		return "WELCOME TO SPRING BOOT ANGULAR INTIGRATION APP";
	}
	
	@GetMapping("/greet-msg")
	public String getGreetMessage() {
		System.out.println("getGreetMessage() method called..");
		return "GOOD MORNING TO ALL SPRING BOOT ANGULAR DEVELOPER";
	}
}
