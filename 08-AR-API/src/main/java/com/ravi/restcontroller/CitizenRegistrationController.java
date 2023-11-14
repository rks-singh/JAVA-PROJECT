package com.ravi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.binding.CitizenRegistration;
import com.ravi.service.CitizenRegistrationService;

@RestController
public class CitizenRegistrationController {

	@Autowired
	private CitizenRegistrationService citizenService;
	
	@PostMapping(value = "/create", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> saveCitizenDetails(@RequestBody CitizenRegistration request){
		
		String response = citizenService.saveCitizenDetails(request);
		
		if("Application Created".equals(response)) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else if("Invalid SSN".equals(response)) {
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/applications/{citizenId}/{citizenType}", produces = "application/json")
	public ResponseEntity<List<CitizenRegistration>> getCitizenDetails(@PathVariable("citizenId") Integer citizenId,@PathVariable("citizenType") String citizenType){
		List<CitizenRegistration> details = citizenService.getCitizenRegistrationsDetails(citizenId, citizenType);
		return new ResponseEntity<>(details,HttpStatus.OK);
	}
}
