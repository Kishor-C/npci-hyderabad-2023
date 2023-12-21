package com.npci.springbootdb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springbootdb.entities.Contact;
import com.npci.springbootdb.entities.Profile;
import com.npci.springbootdb.exceptions.ProfileNotFoundException;
import com.npci.springbootdb.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
// CORS - Cross Origin Resource Sharing - enable CORS for the client applications
@CrossOrigin(origins = "*")
public class ProfileController {

	// inject service layer
	@Autowired
	private ProfileService profileService;
	
	// store profile : consumes JSON because client sends JSON {"name", "password", "birthday", "phone"}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Profile profile) {
		// since there are no exception to handle we can directly call profileService.store in return
		return ResponseEntity.status(201).body(profileService.store(profile));
	}
	// find all profiles : automatically JSON will be the representation
	@GetMapping
	public ResponseEntity<Object> fetchAll() {
		try {
			List<Profile> list = profileService.fetchProfiles();
			return ResponseEntity.status(200).body(list);
		} catch(ProfileNotFoundException e) {
			String message = e.getMessage();//every exception class has getMessage()
			Map<String, String> error = new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); // map will be converted to JSON
		}
	} 
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateProfile(@PathVariable("id") int id, @RequestBody Profile profile) {
		try {
			return ResponseEntity.status(200).body(profileService.updateProfile(id, profile));
		} catch(ProfileNotFoundException e) {
			String message = e.getMessage();//every exception class has getMessage()
			Map<String, String> error = new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); // map will be converted to JSON
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable("id") int id) {
		try {
			Profile profile = profileService.fetchProfile(id);
			return ResponseEntity.status(200).body(profile);
		} catch(ProfileNotFoundException e) {
			String message = e.getMessage();//every exception class has getMessage()
			Map<String, String> error = new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); // map will be converted to JSON
		}
	}
	// add contacts for a profile
	@PostMapping(path = "/contact/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addContact(@RequestBody Contact contact, 
			@PathVariable("id") int profileId) {
		Contact contact2 = profileService.addContact(contact, profileId);
		return ResponseEntity.status(201).body(contact2);
	}
	// list contacts for a profile
	@GetMapping(path = "/contact/{id}")
	public ResponseEntity<Object> fetchContactsById(@PathVariable("id") int id) {
		List<Contact> contacts = profileService.getContacts(id);
		return ResponseEntity.status(200).body(contacts);
	}
	
}
