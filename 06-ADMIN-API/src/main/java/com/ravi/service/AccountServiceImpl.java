package com.ravi.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.AccountEntity;
import com.ravi.repository.AccountRepository;
import com.ravi.request.AccountRequest;
import com.ravi.utils.EmailUtils;



@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveAccount(AccountRequest request) {
	
			AccountEntity accountEntity = new AccountEntity();
			BeanUtils.copyProperties(request, accountEntity);
			accountEntity.setActiveSwitch("Y");
			accountRepository.save(accountEntity);
			
			// Sending Email with Credential.
			String subject = "IES ACCOUNT CREATED.";
			String body = "Your Temporary Password => "+ generatePassword();
			boolean status = emailUtils.sendEmail(request.getEmailId(), subject, body);
			return status;
	}

	@Override
	public List<AccountEntity> getAccounts() {
		List<AccountEntity> accounts = accountRepository.findAll();
		return accounts;
	}

	//Generating Random Password.
	public String generatePassword() {
		Supplier<String> s=()-> 
		{ 
			String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
			Supplier<Integer> digit=()->(int)(Math.random()*10); 
			Supplier<Character> character=()->symbols.charAt((int)(Math.random()*26)); 
			String pwd="";
			
			for(int i=1;i<=8;i++) 
			{ 
				if(i%2==0) 
				{ 
					pwd=pwd+digit.get(); 
				} 
				else 
				{ 
					pwd=pwd+character.get(); 
				} 
			}
			return pwd;	
		};
		String password = s.get();
		return password;
	}	
}
