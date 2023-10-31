package com.ravi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ravi.model.Citizen;
import com.ravi.model.CitizenInfo;

@Service
public class SSNServiceImpl implements SSNService {

	@Override
	public CitizenInfo getCitizenInfo(Citizen citizen) {
		
		String stateInfo = getStateInfo(citizen.getSSN());
		
		CitizenInfo citizenInfo = new CitizenInfo();
		
		BeanUtils.copyProperties(citizen, citizenInfo);
		
		citizenInfo.setStateName(stateInfo);
		
		return citizenInfo;
	}

	@Override
	public String getStateInfo(String SSN) {
		
		char code = SSN.charAt(0);
		
		switch(code) {
		case '1' :
			return " New Jersey";
		case '2' :
			return "Ohio";
		case '3' :
			return "Texas";
		case '4' :
			return "California";
		case '5' : 
			return "Rhode Island";
		case '6' :
			return "Kentucky";
		default :
			return "Invalid SSN";
		}
	}

}
