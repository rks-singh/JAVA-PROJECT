package com.ravi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.request.ChangePasswordRequest;
import com.ravi.request.SignInRequest;
import com.ravi.request.SignUpRequest;
import com.ravi.response.LoginResponse;
import com.ravi.response.SignUpResponse;
import com.ravi.service.UserService;

@RestController
public class UserRestController {   

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SignUpResponse> userRegistration(@RequestBody SignUpRequest request) {

		SignUpResponse response = userService.saveUser(request);

		if (response.getSuccessMessage() != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else if (response.getErrorMessage().contains("Duplicate Email")) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LoginResponse> userLogin(@RequestBody SignInRequest request) {
		LoginResponse response = userService.userLogin(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/update-pwd", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LoginResponse> changePassword(@RequestBody ChangePasswordRequest request) {
		LoginResponse response = userService.updatePassword(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/recover-pwd/{email}")
	public ResponseEntity<String> recoverPassword(@PathVariable String email) {
		boolean status = userService.recoverPassword(email);
		if (status) {
			return new ResponseEntity<String>("Password sent to your Email", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid Email", HttpStatus.BAD_REQUEST);
		}
	}

}
