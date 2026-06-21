package com.premit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.premit.dto.UserDto;
import com.premit.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path="/register",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String userRegistration(@RequestBody UserDto userDto) {
		System.out.println("UserController.userRegistration()::DataReceived::userDto:"+userDto);
	 	String result = userService.userRegistration(userDto);
		return result;
	}
	
}
