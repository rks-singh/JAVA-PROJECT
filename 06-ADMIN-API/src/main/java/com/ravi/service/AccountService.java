package com.ravi.service;

import java.util.List;

import com.ravi.entity.AccountEntity;
import com.ravi.request.AccountRequest;

public interface AccountService {

	public boolean saveAccount(AccountRequest account);

	public List<AccountEntity> getAccounts();
}
