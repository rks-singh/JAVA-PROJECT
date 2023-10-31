package com.ravi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.model.Citizen;
import com.ravi.model.CitizenInfo;
import com.ravi.service.SSNService;

@RestController
public class SSNRestController {
	
	@Autowired
	private SSNService ssnService;

	@PostMapping(value = "/citizen", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CitizenInfo> getCitizenInfo(@RequestBody Citizen citizen) {

		CitizenInfo citizenInfo = ssnService.getCitizenInfo(citizen);

		return new ResponseEntity<>(citizenInfo, HttpStatus.OK);
	}
}
