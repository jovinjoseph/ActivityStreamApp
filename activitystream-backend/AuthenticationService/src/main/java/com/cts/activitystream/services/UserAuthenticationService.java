package com.cts.activitystream.services;

import java.util.List;
import java.util.Optional;

import com.cts.activitystream.domain.User;
import com.cts.activitystream.exceptions.UserAlreadyExistsException;
import com.cts.activitystream.exceptions.UserNotFoundException;

public interface UserAuthenticationService {

	boolean saveUser(User user) throws UserAlreadyExistsException, UserNotFoundException;
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public List<User> list();
	
	public boolean validate(String username, String password);
	
	public Optional<User> get(String username);
	
	public boolean exists(String username);
}
