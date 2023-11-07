package com.ravi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.entity.AccountEntity;
import com.ravi.request.AccountRequest;
import com.ravi.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@PostMapping(value = "/account", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> saveAccount(@RequestBody AccountRequest account) {
		boolean status = accountService.saveAccount(account);
		if (status) {
			return new ResponseEntity<String>("Account Created", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Account not Created", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/accounts", produces = "application/json")
	public ResponseEntity<List<AccountEntity>> getAccounts() {
		List<AccountEntity> accounts = accountService.getAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

}
