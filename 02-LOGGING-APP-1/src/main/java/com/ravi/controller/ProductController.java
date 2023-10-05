package com.ravi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/product")
	public String getProduct() {
		
		logger.info("Product() methos execution start...");
		String msg = null;
		msg.length();
		logger.info("Product() methos execution end...");
		return "Product not availbale";
	}

}
