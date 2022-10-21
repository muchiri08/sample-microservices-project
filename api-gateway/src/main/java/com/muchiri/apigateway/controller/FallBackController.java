package com.muchiri.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/user-service-fallback")
	public String userServiceFallBackMethod() {
		System.out.println("fallback method called");
		return "User service has taken longer than expected. Please try again later";
	}
	
	@GetMapping("/department-service-fallback")
	public String departmentServiceFallBackMethod() {
		return "Department service has taken longer than expected. Please try again later";
	}

}
