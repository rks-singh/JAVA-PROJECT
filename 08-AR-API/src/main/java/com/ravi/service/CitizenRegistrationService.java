package com.ravi.service;

import java.util.List;

import com.ravi.binding.CitizenRegistration;

public interface CitizenRegistrationService {

	public String saveCitizenDetails(CitizenRegistration citizen);

	public List<CitizenRegistration> getCitizenRegistrationsDetails(Integer citizenId, String citizenType);
	
}
