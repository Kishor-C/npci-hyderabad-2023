package com.npci.secondms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients // scans for @FeignClient
public class SecondMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMsApplication.class, args);
	}
	/*
	 *  LoadBalancer: Ribbon-aware RestTemplate which can resolve the address using
	 *  the instance-id of the Microservice
	 */
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemp() {
		return new RestTemplate();
	}

}
