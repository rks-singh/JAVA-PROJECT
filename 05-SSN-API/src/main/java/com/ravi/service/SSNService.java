package com.ravi.service;

import com.ravi.model.Citizen;
import com.ravi.model.CitizenInfo;

public interface SSNService {

	public CitizenInfo getCitizenInfo(Citizen citizen);

	public String getStateInfo(String SSN);
}
