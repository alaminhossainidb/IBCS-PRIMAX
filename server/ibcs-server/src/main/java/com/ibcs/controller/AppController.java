package com.ibcs.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")

public class AppController {

	private static final Logger log = LogManager.getLogger(AppController.class);
	
	
	@GetMapping(value = "/test")
	public String testMethod() {
		return "OK";
	}
}
