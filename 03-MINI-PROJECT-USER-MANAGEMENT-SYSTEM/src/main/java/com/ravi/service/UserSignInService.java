package com.ravi.service;

import com.ravi.entitymodel.UserLogin;

public interface UserSignInService {

	public String saveLoginDetails(UserLogin user);
	
	public String updatePassword(String password, String email);
	
	public String updateAccountStatus(String status, String email);
	
	public String getPassword(String email);
	
	public String getAccountStatus(String email);
	
	public String getEmail(String email);
}
