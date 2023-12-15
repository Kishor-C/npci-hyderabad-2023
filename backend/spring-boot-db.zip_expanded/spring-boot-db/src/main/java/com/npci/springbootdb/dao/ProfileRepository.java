package com.npci.springbootdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.springbootdb.entities.Profile;

// this interface is automatically implemented by spring boot & also registers its object in container
// it gets all the methods of JpaRepository - save, delete, findById, findAll
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	// inherits save(T) as save(Profile), List<T> findAll as List<Profile> findAll
	// we can create custom methods to perform operations that are not present in the JpaRepository
	
	/*
	 * @Query("select p from Profile p where p.phone = ?1")
	 * public Profile getByPhone(long phone)
	 */
	 @Query("select p from Profile p where p.phone = ?1")
	 public Profile getByPhone(long phone); // spring boot implements this also
	 /*
	  * We can write query to update, but it must have @Modify annotation
	  * @Modify
	  * @Query("update Profile p set p.password = ?2 where p.phone = ?1
	  * public Profile updatePasswordByPhone(long phone, String password)
	  */
}
