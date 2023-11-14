package com.ravi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.binding.EligibilityDeterminationInfo;
import com.ravi.service.EligibilityDeterminationService;

@RestController
public class EligibilityDeterminationRestController {

	@Autowired
	private EligibilityDeterminationService eligibilityService;
	
	@GetMapping(value = "/eligibility/{caseNumber}", produces = "application/json")
	public ResponseEntity<EligibilityDeterminationInfo> determineEligibility(@PathVariable Integer caseNumber){
		
		EligibilityDeterminationInfo eligibility = eligibilityService.determinEligibility(caseNumber);
		return new ResponseEntity<>(eligibility,HttpStatus.OK);
	}
}
