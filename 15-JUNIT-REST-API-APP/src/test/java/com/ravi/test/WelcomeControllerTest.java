package com.ravi.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ravi.rest.WelcomeController;
import com.ravi.service.WelcomeService;

@WebMvcTest(value = WelcomeController.class)
public class WelcomeControllerTest {

	@MockBean
	private WelcomeService welcomeService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetWelcomeMessage() throws Exception {
		
		// Defining behavior for mock object.
		when(welcomeService.getMessage()).thenReturn("WELCOME, GOOD MORNING!!");
		
		// Prepare HTTP Request.
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/message");
		
		// Sending request and holding response.
		 MvcResult result = mvc.perform(requestBuilder).andReturn();
		 
		// Validate Response.
		 int status = result.getResponse().getStatus();
		 assertEquals(200, status);
	}
	
	@Test
	public void testGetGreetMessage() throws Exception {
		
		// Defining behavior for mock object.
		when(welcomeService.getGreetMessage()).thenReturn("WELCOME, GOOD MORNING!!");
		
		// Prepare HTTP Request.
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		
		// Sending request and holding response.
		 MvcResult result = mvc.perform(requestBuilder).andReturn();
		 
		 // Validate Response.
		 int status = result.getResponse().getStatus();
		 assertEquals(200, status);
	}
}
