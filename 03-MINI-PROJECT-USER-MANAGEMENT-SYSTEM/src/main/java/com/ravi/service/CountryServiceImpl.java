package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Object[]> getAllCountries() {
		return countryRepository.getAllCountries();
	}

	@Override
	public List<Object[]> getStatesByCountry(Integer id) {
		return countryRepository.getStatesByCountry(id);
	}

}
