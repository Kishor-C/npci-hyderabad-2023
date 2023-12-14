package com.npci.springbootdemo;

import org.springframework.stereotype.Service;

@Service // bean id will be profileService by default
public class ProfileService {
	public void printHello() {
		System.out.println("Hello Everyone");
	}
}
