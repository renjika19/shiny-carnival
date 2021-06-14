package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
//This is the only thing we need to add for this project
//to act as a Eureka Discovery Server
//The other thing we need to do is edit the 
//application.properties/ application.yml


@SpringBootApplication
public class EurekaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				EurekaDiscoveryApplication.class, args);
	}

}
