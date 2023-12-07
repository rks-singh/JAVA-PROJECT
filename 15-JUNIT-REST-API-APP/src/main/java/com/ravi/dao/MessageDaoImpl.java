package com.ravi.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Override
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return "Hi";
	}

	@Override
	public String getGreetMesssage() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
