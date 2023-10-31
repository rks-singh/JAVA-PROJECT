package com.ravi.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.AccountEntity;
import com.ravi.model.Account;
import com.ravi.repository.AccountRepository;
import com.ravi.utils.EmailDetails;
import com.ravi.utils.EmailUtils;



@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String saveAccount(Account account) {
		try {
			AccountEntity accountEntity = new AccountEntity();
			BeanUtils.copyProperties(account, accountEntity);
			accountEntity.setActiveSwitch("Y");
			accountRepository.save(accountEntity);

		} catch (Exception e) {
			return "Account Not Created";
		}

		//Sending Email.
		EmailDetails details = new EmailDetails();
		details.setSubject("--- Password Details ---");
		details.setMsgBody("Your Password : "+generatePassword());
		details.setRecipient("rks884088@gmail.com"); // account.getEmialId().
		emailUtils.sendEmial(details);
		
		return "Account Created";
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
			String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@"; 
			Supplier<Integer> d=()->(int)(Math.random()*10); 
			Supplier<Character> c=()->symbols.charAt((int)(Math.random()*29)); 
			String pwd="";
			
			for(int i=1;i<=8;i++) 
			{ 
				if(i%2==0) 
				{ 
					pwd=pwd+d.get(); 
				} 
				else 
				{ 
					pwd=pwd+c.get(); 
				} 
			}
			return pwd;	
		};
		String password = s.get();
		return password;
	}	
}
