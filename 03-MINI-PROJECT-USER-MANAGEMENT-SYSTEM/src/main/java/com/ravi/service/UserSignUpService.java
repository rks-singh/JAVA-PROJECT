package com.ravi.service;

import com.ravi.entitymodel.UserLogin;

public interface UserSignUpService {

	public String saveSignUpDetails(UserLogin user);

	public String findByEmail(String email);

}
