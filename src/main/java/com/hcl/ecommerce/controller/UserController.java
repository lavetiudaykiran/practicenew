package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.exception.CustomException;
import com.hcl.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping()
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) throws CustomException {
		
		String response = userService.addUser(userDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<String> loginUser(@RequestParam String userName, @RequestParam String password)
			throws CustomException {
		
		String response = userService.loginUser(userName, password);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
