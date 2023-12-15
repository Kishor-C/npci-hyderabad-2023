package com.npci.springbootdemo.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springbootdemo.beans.Profile;

@RestController
@RequestMapping("/api") // this is the entry point for HelloApi
public class HelloApi {
	// consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> store(@RequestBody Profile profile) {
		// @RequstBody reads the content & initializes Profile object
		// Response Body will have status code & profile object which will be auto-converted to JSON
		return ResponseEntity.status(201).body(profile);
	}
	
	@GetMapping(path = "/greet/{x}") // this must be access using GET: http://localhost:8082/api/greet
	public ResponseEntity<String> welcome(@PathVariable("x") String name) {
		/*
		 * ResponseEntity is a wrapper for a response that will have content & status code
		 * like success/failure content and HTTP status code: 200, 404
		 * parameter name can accept a value from the client
		 */
		// returns the response content Welcome and status code
		if(name != null && !name.isBlank()) {
			return ResponseEntity.status(200).body("Welcome "+name);
		} else {
			return ResponseEntity.status(200).body("Welcome Guest");
		}
	}
}
