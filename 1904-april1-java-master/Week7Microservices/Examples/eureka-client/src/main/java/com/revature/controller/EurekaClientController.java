package com.revature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping("/name")
	public String getName() {
		return appName;
	}
}
