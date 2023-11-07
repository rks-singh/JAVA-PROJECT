package com.ravi.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ravi.entity.UserEntity;
import com.ravi.repository.UserRepository;
import com.ravi.request.ChangePasswordRequest;
import com.ravi.request.SignInRequest;
import com.ravi.request.SignUpRequest;
import com.ravi.response.DashBoardResponse;
import com.ravi.response.LoginResponse;
import com.ravi.response.SignUpResponse;
import com.ravi.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public SignUpResponse saveUser(SignUpRequest request) {

		SignUpResponse response = new SignUpResponse();

		// Validating Unique EmialId.
		UserEntity user = userRepository.findByEmail(request.getEmail());

		if (user != null) {
			response.setErrorMessage("Duplicate Email");
			return response;
		}

		// Getting Temporary Password.
		String password = generatePassword();
		request.setPassword(password);
		request.setIsPasswordChanged("false");

		// Saving User Recored in DB.
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(request, userEntity);
		userRepository.save(userEntity);

		// Sending Email to User with their Credentials.
		String subject = "IES ACCOUNT CREATED";
		String body = "Your Temporary Password TO Login => " + password;
		boolean status = emailUtils.sendEmail(request.getEmail(), subject, body);

		if (status) {
			response.setSuccessMessage("Registration Success");
		} else {
			response.setErrorMessage("Registration Failed");
		}
		return response;
	}

	@Override
	public LoginResponse userLogin(SignInRequest request) {

		LoginResponse response = new LoginResponse();

		// Checking User with given Email and Password Exist or not.
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());

		List<UserEntity> record = userRepository.findAll(Example.of(entity));

		// If user exist.
		if (!(record.isEmpty())) {

			UserEntity user = record.get(0);

			response.setUserId(user.getUserId());
			response.setName(user.getName());
			response.setUserType(user.getUserType());

			if (user.getIsPasswordChanged().equals("true")) {

				// Second Login after password change.
				response.setIsPasswordChanged("true");
				response.setIsValidLogin(true);

				// Setting DashBoard Response data.
				DashBoardResponse dashBoardResponse = new DashBoardResponse();
				dashBoardResponse.setPlanCount(6l);
				dashBoardResponse.setTotalBenifitAmount(34000.00);
				dashBoardResponse.setCitizensApprovedCount(10000l);
				dashBoardResponse.setCitizensDeniedCount(500l);

				response.setDashBoardResponse(dashBoardResponse);

			} else {

				// First Login required password change.
				response.setIsPasswordChanged("false");
				response.setIsValidLogin(true);
			}
			// If user not exist.
		} else {
			response.setIsValidLogin(false);
			response.setIsPasswordChanged("false");
		}
		return response;
	}

	@Override
	public LoginResponse updatePassword(ChangePasswordRequest request) {

		LoginResponse response = new LoginResponse();

		Integer userId = request.getUserId();
		Optional<UserEntity> result = userRepository.findById(userId);

		if (result.isPresent()) {

			// Updating Password.
			UserEntity user = result.get();
			user.setPassword(request.getPassword());
			user.setIsPasswordChanged("true");
			userRepository.save(user);

			response.setUserId(user.getUserId());
			response.setName(user.getName());
			response.setUserType(user.getUserType());
			response.setIsPasswordChanged("true");
			response.setIsValidLogin(true);

			// Setting DashBoard Response data.
			DashBoardResponse dashBoardResponse = new DashBoardResponse();
			dashBoardResponse.setPlanCount(6l);
			dashBoardResponse.setTotalBenifitAmount(34000.00);
			dashBoardResponse.setCitizensApprovedCount(10000l);
			dashBoardResponse.setCitizensDeniedCount(500l);

			response.setDashBoardResponse(dashBoardResponse);

		}
		return response;
	}

	@Override
	public boolean recoverPassword(String email) {

		UserEntity user = userRepository.findByEmail(email);

		if (user == null) {
			return false;
		}
		String subject = "IES RECOVERED PASSWORD";
		String body = "Your Recovered Password => " + user.getPassword();
		boolean status = emailUtils.sendEmail(email, subject, body);

		return status;
	}

	// Generating Random Password.
	public String generatePassword() {
		Supplier<String> s = () -> {
			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			Supplier<Integer> digit = () -> (int) (Math.random() * 10);
			Supplier<Character> character = () -> symbols.charAt((int) (Math.random() * 26));
			String pwd = "";

			for (int i = 1; i <= 8; i++) {
				if (i % 2 == 0) {
					pwd = pwd + digit.get();
				} else {
					pwd = pwd + character.get();
				}
			}
			return pwd;
		};
		String password = s.get();
		return password;
	}

}
