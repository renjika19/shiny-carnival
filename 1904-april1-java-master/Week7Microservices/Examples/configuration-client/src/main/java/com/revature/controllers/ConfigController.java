package com.revature.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
	@Value("${message}")
	private String message;
	
	@RequestMapping("/message")//GET
	String getMessage() {
		return this.message;
	}
}
