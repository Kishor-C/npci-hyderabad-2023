package com.npci.secondms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.npci.secondms.beans.Account;

// interface having REMOTE URL
@FeignClient("http://ACCOUNT-MS/api/first")
public interface AccountClient {
	// method that sends HTTP request to the Remote service
	@GetMapping(path = "/{acc}")
	public Account getAccountDetails(@PathVariable("acc") long acc);
	//above method sends HTTP GET request to the account microservice
}
