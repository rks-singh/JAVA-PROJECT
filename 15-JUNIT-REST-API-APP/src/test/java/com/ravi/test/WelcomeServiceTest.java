package com.ravi.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ravi.dao.MessageDao;
import com.ravi.service.WelcomeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class WelcomeServiceTest {

	@MockBean
	private MessageDao messageDao;
	
	@InjectMocks
	private WelcomeService welcomeService;
	
	@Test
	public void testGetWelcomeMessage() {
		when(messageDao.getWelcomeMessage()).thenReturn("WELCOME, GOOD MORNING!!");
		String message = welcomeService.getWelcomeMessage();
		assertNotNull(message);
	}
	
	@Test
	public void testGreetMessage() {
		when(messageDao.getGreetMesssage()).thenReturn("GOOD MORNING!!");
		String message = welcomeService.getGreetMessage();
		assertNotNull(message);
	}
}
