package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.dao.MessageDao;

@Service
public class WelcomeService {

	@Autowired
	private MessageDao messageDao;
	
	public String getWelcomeMessage() {
		String message = messageDao.getWelcomeMessage();
		return message;
	}
	
	public String getGreetMessage() {
		String messsage = messageDao.getGreetMesssage();
		return messsage;
	}
}
