package com.cts.activitystream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.activitystream.model.User;
import com.cts.activitystream.service.UserService;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@CrossOrigin(origins = "*")
@RestController
public class UserController {

	/*
	 * Autowiring should be implemented for the UserService. 
	 * Please note that we should not create any object using the new keyword 
	 */
	@Autowired
	private UserService userService;
	
	/* Define a handler method which will list all the available users.
	 * This handler method should return any one of the status messages basis on different
	 * situations:
	 * 1. 200(OK) - If login is successful
	 * 
	 * This handler method should map to the URL "/api/user" using HTTP GET method
	*/
	@GetMapping(value = "/api/user/" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listAllUsers(HttpServletRequest request, UriComponentsBuilder ucBuilder) {
		List<User> users = userService.list();
		HttpHeaders headers = new HttpHeaders();		
		return new ResponseEntity<List<User>>(users, headers, HttpStatus.OK);
	}
	/* Define a handler method which will show details of a specific user.
	 * This handler method should return any one of the status messages basis on different
	 * situations:
	 * 1. 200(OK) - If login is successful
	 * 2. 404(NOT FOUND) - If the user with the searched for is not found
	 * This handler method should map to the URL "/api/user/{username}" using HTTP GET method
	 * where "username" should be replaced by a username without {}
	*/
	@GetMapping(value = "/api/user/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username, HttpServletRequest request) {
		User user = userService.get(username);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	/* Define a handler method which will create a specific user by reading the 
	 * Serialized object from request body and save the user details in user table 
	 * in database. This handler method should return any one of the status messages
	 *  basis on different situations:
	 * 1. 201 (CREATED) - If the user is successfully created
	 * 2. 409 (CONFLICT) - If the username conflicts with any existing user
	 * 
	 * Note:
	 * ------
	 * This method can be called without being logged in as well as when a new user will
	 * use the app, he will register himself first before login.
	 * This handler method should map to the URL "/api/user" using HTTP POST method
	*/
	@PostMapping(value = "/api/user/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (userService.get(user.getUsername()) == null) {
			userService.save(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("user/{id}").buildAndExpand(user.getUsername()).toUri());
			return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
		}

		return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}
	
	/* Define a handler method which will update an specific user by reading the 
	 * Serialized object from request body and save the updated user details in user table 
	 * in database. This handler method should return any one of the status messages
	 *  basis on different situations:
	 * 1. 200(OK) - If the user is successfully updated
	 * 2. 404(NOT FOUND) - If the user with specified username is not found
	 * 
	 * This handler method should map to the URL "/api/user/{username}" using HTTP PUT method
	*/
	@PutMapping(value = "/api/user/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, HttpServletRequest request,
			@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (userService.get(username) != null) {
				userService.update(user);
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("user/{username}").buildAndExpand(user.getUsername()).toUri());
				return new ResponseEntity<User>(user, headers, HttpStatus.OK);
			}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}
