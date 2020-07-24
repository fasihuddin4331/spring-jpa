package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	public Contact findByEmail(String email);
	
	@Query("from com.example.demo.Contact c join c.placeEntities p where p.placeName=:name")
	public List<Contact> findByPlaceName(String name);
	
	public List<Contact> findByNameAndEmail(String name,String email);
  }
