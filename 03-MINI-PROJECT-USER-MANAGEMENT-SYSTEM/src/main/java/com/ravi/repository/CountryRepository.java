package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entitymodel.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query("SELECT c.id,c.name FROM Country c")
	List<Object[]> getAllCountries();
	
	@Query("SELECT s.id,s.name FROM Country c JOIN c.states AS s WHERE c.id=:id")
	List<Object[]> getStatesByCountry(Integer id);
}
