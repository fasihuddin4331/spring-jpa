package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PlaceEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String placeName;
	
	@ManyToMany
	List<Contact> contacts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
}
