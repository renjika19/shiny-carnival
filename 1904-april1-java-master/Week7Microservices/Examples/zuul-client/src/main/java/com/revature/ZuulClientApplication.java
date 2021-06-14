package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZuulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulClientApplication.class, args);
	}

}
