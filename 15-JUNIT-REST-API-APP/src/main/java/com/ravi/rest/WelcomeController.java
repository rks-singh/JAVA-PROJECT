package com.ravi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	
	@GetMapping("/message")
	public ResponseEntity<String> getWelcomeMessage(){
		String name = welcomeService.getClass().getName();
		System.out.println(name);
		String message = welcomeService.getWelcomeMessage();
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@GetMapping("/greet")
	public ResponseEntity<String> getGreetMessage(){
		String message = welcomeService.getGreetMessage();
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}
