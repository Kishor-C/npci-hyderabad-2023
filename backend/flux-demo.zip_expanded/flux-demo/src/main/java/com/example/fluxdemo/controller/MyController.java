package com.example.fluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fluxdemo.service.ServiceImpl;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	private ServiceImpl service;
	// responds after 5s
	@GetMapping("/synch")
	public ResponseEntity<Object> fetchUsersBySync() {
		return ResponseEntity.status(200).body(service.fetchAll());
	}
	// responds for every 1s
	// test this in browser not in postman/thunder client
	// to publish the data we must use MediaType.TEXT_EVENT_STREAM_VALUE
	@GetMapping(path = "/asynch", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Object> fetchUsersByAsync() {
		return ResponseEntity.status(200).body(service.fetchAllByFlux());
	}
}
