package com.ravi.entitymodel;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Country {
	
	@Id
	private Integer id;
	private String name;
	@OneToMany
	@JoinColumn(name="state_id")
	private Set<State> states;
	
	public Country() {}
	
	public Country(Integer id, String name, Set<State> states) {
		this.id = id;
		this.name = name;
		this.states = states;
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

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}



	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", states=" + states + "]";
	}
	
	
	
}
