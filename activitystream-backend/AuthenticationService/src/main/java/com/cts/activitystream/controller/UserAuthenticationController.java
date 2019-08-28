package com.cts.activitystream.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.activitystream.domain.User;
import com.cts.activitystream.services.SecurityTokenGenerator;
import com.cts.activitystream.services.UserAuthenticationService;

@RestController
//@EnableWebMvc
@CrossOrigin(origins ="*")
@RequestMapping("/api/v1/userservice")
public class UserAuthenticationController {

	private UserAuthenticationService userService;

	private SecurityTokenGenerator tokenGenerator;

	@Autowired
	public UserAuthenticationController(UserAuthenticationService userService, SecurityTokenGenerator tokenGenerator) {
		super();
		this.userService = userService;
		this.tokenGenerator = tokenGenerator;
	}

	public UserAuthenticationController() {
		super();
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			user.setCreated();
			userService.saveUser(user);
			return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>("{\" message \": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User loginDetail) {
		try {
			String userId = loginDetail.getUsername();
			String password = loginDetail.getPassword();
			if (userId == null || password == null) {
				throw new Exception("Username or password cannot be empty");
			}
			User user = userService.findByUserIdAndPassword(userId, password);
			if (user == null) {
				throw new Exception("User with given id does not exist");

			}
			String pwd = user.getPassword();
			if (!password.equals(pwd)) {
				throw new Exception("Invalid login credential, please check user name and password");
			}
			Map<String, String> map = tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("{\" message \": \"" + e.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}
}
