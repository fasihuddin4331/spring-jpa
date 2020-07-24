package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;
	
	@Autowired
	PlaceReository placeRepo;

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact> > getContacts() {
		 List<Contact> list = (List<Contact>) repository.findAll();
		 return new ResponseEntity(list,HttpStatus.OK);
	}

	@PostMapping("/contacts")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		 Contact contact2 = repository.save(contact);
		return new ResponseEntity<Contact>(contact2,HttpStatus.CREATED);
	}
	
	@GetMapping("/contacts/{email}")
	public ResponseEntity<String> deleteContact(@PathVariable String email) {
		try {
			Contact contact = repository.findByEmail(email);
			if(contact!=null) {
				repository.delete(contact);
				return new ResponseEntity<String>("Contact Details Deleted Success Fully",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No ConTact Found with this id",HttpStatus.CREATED);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Server is Not Responding Try After Some Time ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/*@GetMapping("/contacts/byPlaceName/{placeName}")
	public ResponseEntity<List<Contact> > getByPlaceName(@PathVariable String placeName) {
		
		 return new ResponseEntity(list,HttpStatus.OK);
	}
*/
}
