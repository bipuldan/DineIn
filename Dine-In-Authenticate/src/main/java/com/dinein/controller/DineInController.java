package com.dinein.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinein.model.User;
import com.dinein.services.JwtSecurityTokenGenerator;
import com.dinein.services.UserService;

@RestController
@CrossOrigin
public class DineInController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private JwtSecurityTokenGenerator tokenGenerator;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("sdfsf");

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			if (null == user.getEmail() || null == user.getPassword()) {
				throw new Exception("User Id or Password canot be empty.");
			}
			User user1 = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
			Map<String, String> map = tokenGenerator.generateToken(user1);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}


}
