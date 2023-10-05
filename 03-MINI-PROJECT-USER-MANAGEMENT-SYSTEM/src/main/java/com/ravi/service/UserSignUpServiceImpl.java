package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entitymodel.UserLogin;
import com.ravi.entitymodel.UserSignUp;
import com.ravi.repository.UserSignUpRepository;

@Service
public class UserSignUpServiceImpl implements UserSignUpService {

	@Autowired
	private UserSignUpRepository userSignUpRepository;

	@Override
	public String saveSignUpDetails(UserLogin user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByEmail(String email) {
		UserSignUp findByEmail = userSignUpRepository.findByEmail(email);
		return (findByEmail == null) ? "Unique" : "Duplicate";
	}
}
