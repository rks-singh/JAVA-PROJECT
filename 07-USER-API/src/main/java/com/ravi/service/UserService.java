package com.ravi.service;

import com.ravi.request.ChangePasswordRequest;
import com.ravi.request.SignInRequest;
import com.ravi.request.SignUpRequest;
import com.ravi.response.LoginResponse;
import com.ravi.response.SignUpResponse;

public interface UserService {

	public SignUpResponse saveUser(SignUpRequest request);

	public LoginResponse userLogin(SignInRequest request);

	public LoginResponse updatePassword(ChangePasswordRequest request);

	public boolean recoverPassword(String email);
}
