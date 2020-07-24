package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	public Contact findByEmail(String email);
	
	@Query
	public List<Contact> findByPlaceName(String name);
  }
