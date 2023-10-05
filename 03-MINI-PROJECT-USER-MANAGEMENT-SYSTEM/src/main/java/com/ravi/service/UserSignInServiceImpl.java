package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entitymodel.UserLogin;
import com.ravi.repository.UserLoginRepository;

@Service
public class UserSignInServiceImpl implements UserSignInService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	
	@Override
	public String saveLoginDetails(UserLogin user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassword(String password, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAccountStatus(String status, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountStatus(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
