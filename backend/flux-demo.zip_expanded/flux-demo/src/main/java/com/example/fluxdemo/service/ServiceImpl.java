package com.example.fluxdemo.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ServiceImpl {

	// sleep method 
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	// synchronous operations 
	public List<String> fetchAll() {
		List<String> users = new ArrayList<>();
		// for loop to add 5 data
		for(int i = 1; i <= 5; i++) {
			sleep(1000); // sleeps for 1s
			users.add("User: "+i+" Req Thread Name = "+Thread.currentThread().getName());
		}
		return users;
	}
	// asynchronous operations
	public Flux<String> fetchAllByFlux() {
		// adding 5 data, here the map returns data for each second which is nothing but publishes the data
		// the threads in the thread-pool is notified to subscribe to that data
		return Flux.range(0, 5)
				.delayElements(Duration.ofSeconds(1))
				.map(i -> "User: "+i+" Req Thread Name = "+Thread.currentThread().getName());
	}
}
