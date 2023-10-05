package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entitymodel.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
