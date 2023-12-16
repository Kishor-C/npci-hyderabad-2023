package com.npci.springbootdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.springbootdb.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	
}
