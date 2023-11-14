package com.ravi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ravi.binding.CitizenRegistration;
import com.ravi.entity.CitizenRegistrationEntity;
import com.ravi.repository.CitizenRegistrationRepo;

@Service
public class CitizenRegistrationServiceImpl implements CitizenRegistrationService {

	private final String SSN_API_URL = "http://localhost:9090/ssn/{ssn}";

	@Autowired
	private CitizenRegistrationRepo citizenRegistrationRepo;

	@Override
	public String saveCitizenDetails(CitizenRegistration request) {

		Long citizenSsn = request.getCitizenSsn();
		
		CitizenRegistrationEntity findBycitizenSsn = citizenRegistrationRepo.findBycitizenSsn(citizenSsn);
		if(findBycitizenSsn != null) {
			return "Duplicate Application";
		}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity(SSN_API_URL, String.class, citizenSsn);
		String stateName = entity.getBody();

		if (stateName.equals("Rhode Island")) {
			CitizenRegistrationEntity citizen = new CitizenRegistrationEntity();
			BeanUtils.copyProperties(request, citizen);
			citizenRegistrationRepo.save(citizen);
			return "Application Created";
		}
		return "Invalid SSN";
	}

	@Override
	public List<CitizenRegistration> getCitizenRegistrationsDetails(Integer citizenId, String citizenType) {
		
		List<CitizenRegistrationEntity> entities = null;
		if("Admin".equalsIgnoreCase(citizenType)) {
			entities = citizenRegistrationRepo.findAll();
		}else {
			entities = citizenRegistrationRepo.findByCreatedBy(citizenId);
		}
		
		List<CitizenRegistration> citizenList = new ArrayList<>();
		for(CitizenRegistrationEntity entity : entities) {
			CitizenRegistration citizen = new CitizenRegistration();
			BeanUtils.copyProperties(entity, citizen);
			citizenList.add(citizen);
		}
		return citizenList;
		
	}

}
