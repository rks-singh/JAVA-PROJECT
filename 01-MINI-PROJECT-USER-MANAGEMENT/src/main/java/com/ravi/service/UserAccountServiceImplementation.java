package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.UserAccount;
import com.ravi.repository.UserRepository;

@Service
public class UserAccountServiceImplementation implements UserAccountService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String saveOrUpdateUserAccount(UserAccount userAccount) {
		Integer status = userAccount.getId();
		if (status == null) {
			userAccount.setActiveSwitch("Y");
		}
		userRepository.save(userAccount);
		if (status == null) {
			return "saved";
		} else {
			return "update";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccount() {
		return userRepository.findAll();
	}

	@Override
	public UserAccount getUserAccount(Integer userId) {
		Optional<UserAccount> findById = userRepository.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAccount(Integer userId) {
		boolean existsById = userRepository.existsById(userId);
		if (existsById) {
			userRepository.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserAccountStatus(Integer userId, String status) {
		try {
			userRepository.updateUserAccountStatus(userId, status);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public String getUserAccountStatus(Integer id) {
		return userRepository.getUserActiveSwitch(id);
	}
}
