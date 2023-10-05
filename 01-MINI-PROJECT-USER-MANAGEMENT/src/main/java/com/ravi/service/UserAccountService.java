package com.ravi.service;

import java.util.List;

import com.ravi.entity.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAccount(UserAccount userAccount);

	public List<UserAccount> getAllUserAccount();

	public UserAccount getUserAccount(Integer id);

	public boolean deleteUserAccount(Integer userId);

	public String getUserAccountStatus(Integer id);

	public boolean updateUserAccountStatus(Integer userId, String Status);
}
