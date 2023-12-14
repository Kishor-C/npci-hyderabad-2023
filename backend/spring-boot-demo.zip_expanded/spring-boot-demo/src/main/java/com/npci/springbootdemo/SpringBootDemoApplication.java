package com.npci.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootDemoApplication.class, args);
		ProfileService service = (ProfileService)context.getBean("profileService");
		service.printHello();
		/*
		 * When you run this program you will see a tomcat server starting in 8080
		 * and in the console it shows spring boot banner
		 * and also you will see the Hello World message
		 */
	}
}
/*
 * @SpringBootApplication
 * does Component Scanning from com.npci.springbootdemo
 * 
 */
