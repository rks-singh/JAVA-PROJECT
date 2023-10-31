package com.ravi.service;

import java.util.List;

import com.ravi.entity.AccountEntity;
import com.ravi.model.Account;

public interface AccountService {

	public String saveAccount(Account account);
	public List<AccountEntity> getAccounts();
}
