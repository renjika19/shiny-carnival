package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@RequestMapping("/message")
	public String message() {
		return "Hello! From the client! "+
	"(WARNING: this may have gone through a proxy server)";
	}
}
