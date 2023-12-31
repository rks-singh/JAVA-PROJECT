package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<Object[]> getCitiesByState(Integer id) {
		return stateRepository.getCitiesByState(id);
		
	}

}
