package com.ravi.entitymodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class City {
	
	@Id
	private Integer id;
	private String name;
	
	public City() {}
	
	public City(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	

}
