package com.muchiri.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muchiri.user.entity.User;
import com.muchiri.user.service.UserService;
import com.muchiri.user.valueobject.ResponseTemplateVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("saveUser method inside controller class called");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("getUserWithDepartment method inside controller class called");
		return userService.getUserWithDepartment(userId);
	}

}
