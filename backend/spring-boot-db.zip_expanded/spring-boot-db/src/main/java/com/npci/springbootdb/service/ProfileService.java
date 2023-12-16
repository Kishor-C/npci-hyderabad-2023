package com.npci.springbootdb.service;

import java.util.List;

import com.npci.springbootdb.entities.Contact;
import com.npci.springbootdb.entities.Profile;
import com.npci.springbootdb.exceptions.ProfileNotFoundException;

public interface ProfileService {

	//saving the entity
	Profile store(Profile profile);

	//getting all the entities, throw exception if there are no profiles
	List<Profile> fetchProfiles() throws ProfileNotFoundException;

	//get an entity based on id, else throw exception
	Profile fetchProfile(int id) throws ProfileNotFoundException;
	
	//update an entity based on id, parameter must be id and profile
	Profile updateProfile(int id, Profile profile)throws ProfileNotFoundException;
	
	//add Contact to a profile
	Contact addContact(Contact contact, int profileId);
	
	//list Contacts from a particular profile
	List<Contact> getContacts(int profileId);
	
	//delete Contact from a contact id
	void deleteContact(int contactId);

}