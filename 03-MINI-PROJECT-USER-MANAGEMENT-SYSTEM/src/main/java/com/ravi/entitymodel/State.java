package com.ravi.entitymodel;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class State {

	@Id
	private Integer id;
	private String name;
	@OneToMany
	@JoinColumn(name="state_id")
	private Set<City> cities;

	public State() {}
	
	public State(Integer id, String name, Set<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", cities=" + cities + "]";
	}
	
	
	

}
