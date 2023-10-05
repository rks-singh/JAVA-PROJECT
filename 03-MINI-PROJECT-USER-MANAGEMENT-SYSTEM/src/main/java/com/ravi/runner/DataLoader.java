package com.ravi.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entitymodel.City;
import com.ravi.entitymodel.Country;
import com.ravi.entitymodel.State;
import com.ravi.repository.CityRepository;
import com.ravi.repository.CountryRepository;
import com.ravi.repository.StateRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	@Override
	public void run(String... args) throws Exception {
		
		
		
		City city1 = new City(101, "Lucknow");
		City city2 = new City(102, "Noida");
		
		City city3 = new City(103, "Indore");
		City city4 = new City(104, "Bhopal");
		
		City city5 = new City(105, "Los Angeles");
		City city6 = new City(106, "San Francisco");
		
		City city7 = new City(107, "Orlando");
		City city8 = new City(108, "Miami");
		
		cityRepository.saveAll(Arrays.asList(city1,city2,city3,city4,city5,city6,city7,city8));;
		
		State state1 = new State(201, "Uttar Pradesh", Set.of(city1,city2));
		State state2 = new State(202, "Madhya Pradesh", Set.of(city3,city4));
		
		State state3 = new State(203, "California", Set.of(city5,city6));
		State state4 = new State(204, "Florida", Set.of(city7,city8));
		
		stateRepository.saveAll(Arrays.asList(state1,state2,state3,state4));
		
		Country country1 = new Country(301, "India", Set.of(state1,state2));
		Country country2 = new Country(302, "USA", Set.of(state3,state4));
		
		countryRepository.saveAll(Arrays.asList(country1,country2));
		
		
	}
	
	
}
