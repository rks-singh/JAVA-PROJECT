package com.ravi.service;

import java.util.List;

public interface CountryService {
	
	public List<Object[]> getAllCountries();	

	public List<Object[]> getStatesByCountry(Integer id);
		

}
