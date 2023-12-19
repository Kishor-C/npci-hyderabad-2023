package com.npci.secondms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.npci.secondms.beans.Account;
import com.npci.secondms.beans.Wallet;
import com.npci.secondms.clients.AccountClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class WalletServiceImpl {
	// autowire the RestTemplate
	@Autowired
	private RestTemplate restTemp;
	
	//Injecting the client that makes remote calls
	@Autowired
	private AccountClient client;
	
	// name is used to configure the properties
	@CircuitBreaker(name = "walletInstance", fallbackMethod = "getAlternateWallet")
	// method calls the remote service
	public Wallet getWallet(long account) {
		System.out.println("---- Method making remote call ----");
		//String REMOTE_URL = "http://ACCOUNT-MS/api/first/"+account;
		// from the remote service we get Account in JSON format
		// getForObject converts JSON to Account object based on the properties
		// sends a GET request, Account will be initialized based on the json
		//Account accountDetails = restTemp.getForObject(REMOTE_URL, Account.class);
		Account accountDetails = client.getAccountDetails(account);
		Wallet wallet = new Wallet();
		wallet.setAccountDetails(accountDetails);
		// set wallet id with some random value, here accountNumber + 1
		wallet.setWalletId(accountDetails.getAccount() + 1);
		// add walletAmount with account balance, default walletAmount is 500
		wallet.setTotalAmount(accountDetails.getBalance()+wallet.getWalletAmount());
		return wallet;
	}
	// a fallback method with Throwable argument
	public Wallet getAlternateWallet(long account, Throwable t) {
		System.out.println("--- Method making alternate calls ----");
		// this can make calls to another microservice if necessary
		Wallet wallet = new Wallet();
		return wallet;
	}
}
