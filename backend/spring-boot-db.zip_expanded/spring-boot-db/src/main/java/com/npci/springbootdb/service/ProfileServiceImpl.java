package com.npci.springbootdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.springbootdb.dao.ContactRepository;
import com.npci.springbootdb.dao.ProfileRepository;
import com.npci.springbootdb.entities.Contact;
import com.npci.springbootdb.entities.Profile;
import com.npci.springbootdb.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceImpl implements ProfileService {
	// inject DAO layer to the service
	@Autowired
	private ProfileRepository dao;
	// inject Contact DAO to the service
	@Autowired
	private ContactRepository contactDao;
	//saving the entity
	@Override
	public Profile store(Profile profile) {
		// dao.save returns saved entity hence we are keeping Profile as return type
		Profile savedEntity = dao.save(profile);
		return savedEntity;
	}
	//getting all the entities, throw exception if there are no profiles
	@Override
	public List<Profile> fetchProfiles() throws ProfileNotFoundException{
		List<Profile> profiles = dao.findAll();
		if(profiles.size() == 0)
			throw new ProfileNotFoundException("There are no profiles to fetch");
		else 
			return profiles;
	}
	//get an entity based on id, else throw exception
	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// Optional has a method that returns an object or throws exception in one line
		Optional<Profile> option =  dao.findById(id);
		// orEleseThrow checks internally for null, it either returns the data or throws exception
		return option.orElseThrow(()->new ProfileNotFoundException("Profile with an id "+id+" not found"));
	}
	@Override
	public Profile updateProfile(int id, Profile profile) throws ProfileNotFoundException {
		Profile profile2 = fetchProfile(id);
		if(profile.getBirthday() != null)
		profile2.setBirthday(profile.getBirthday());
		if(profile.getName() != null)
		profile2.setName(profile.getName());
		if(profile.getPassword() != null)
		profile2.setPassword(profile.getPassword());
		if(profile.getPhone() != 0)
		profile2.setPhone(profile.getPhone());
		return dao.save(profile2);
	}
	@Override
	public Contact addContact(Contact contact, int profileId) {
		contact.setProfileRef(profileId); // contact table must know that it is belonging to which profile
		return contactDao.save(contact);
	}
	@Override
	public List<Contact> getContacts(int profileId) {
		Profile profile = dao.findById(profileId).orElse(null);// returns profile or null
		if(profile != null) {
			return profile.getContacts();
		}
		return null;
	}
	@Override
	public void deleteContact(int contactId) {
		// TODO Auto-generated method stub
		
	}
}
