package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entitymodel.UserLogin;
import com.ravi.repository.UserLoginRepository;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	
	@Override
	public String forgetPassword(UserLogin user) {
		// TODO Auto-generated method stub
		return null;
	}

}
