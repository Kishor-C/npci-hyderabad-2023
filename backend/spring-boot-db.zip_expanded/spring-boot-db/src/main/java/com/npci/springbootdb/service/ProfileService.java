package com.npci.springbootdb.service;

import java.util.List;

import com.npci.springbootdb.entities.Profile;
import com.npci.springbootdb.exceptions.ProfileNotFoundException;

public interface ProfileService {

	//saving the entity
	Profile store(Profile profile);

	//getting all the entities, throw exception if there are no profiles
	List<Profile> fetchProfiles() throws ProfileNotFoundException;

	//get an entity based on id, else throw exception
	Profile fetchProfile(int id) throws ProfileNotFoundException;

}