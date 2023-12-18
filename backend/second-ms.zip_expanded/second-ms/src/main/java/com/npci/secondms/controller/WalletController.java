package com.npci.secondms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.secondms.beans.Wallet;
import com.npci.secondms.service.WalletServiceImpl;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
	
	@Value("${message}") // use ${ curly bracket 
	private String msg;
	// create a controller that shows the message injected from the property file
	@GetMapping("/greet/msg")
	public String getMessage() {
		return msg;
	}
	// inject service
	// call getWallet(someValue) - create a controller taking input @PathVariable
	@Autowired
	private WalletServiceImpl service;
	
	@GetMapping(path = "/{acc}")
	public ResponseEntity<Object> getWalletApi(@PathVariable("acc") long accountNumber) {
		Wallet wallet = service.getWallet(accountNumber);
		return ResponseEntity.status(200).body(wallet);
	}
}
