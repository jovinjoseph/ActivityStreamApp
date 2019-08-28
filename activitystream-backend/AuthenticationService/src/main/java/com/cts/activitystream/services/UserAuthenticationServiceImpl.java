package com.cts.activitystream.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.activitystream.domain.User;
import com.cts.activitystream.exceptions.UserAlreadyExistsException;
import com.cts.activitystream.exceptions.UserNotFoundException;
import com.cts.activitystream.repositories.UserAuthenticationRepository;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	private final UserAuthenticationRepository userRepository;

	@Autowired
	public UserAuthenticationServiceImpl(UserAuthenticationRepository userRepo) {
		super();
		this.userRepository = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		final Optional<User> userOpt = userRepository.findById(user.getUsername());
		if (userOpt.isPresent()) {
			throw new UserAlreadyExistsException("User with id already exists");
		}
		userRepository.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String username, String password) throws UserNotFoundException {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user == null) {
			throw new UserNotFoundException("User Id and password mismatch");
		}

		return user;
	}

	/*
	 * This method should be used to save a new user. Call the corresponding
	 * method of Respository interface.
	 */
	public boolean save(User user) {
		userRepository.save(user);
		return true;
	}
	/*
	 * This method should be used to update an existing user. Call the
	 * corresponding method of Respository interface.
	 */
	public boolean update(User user) {
		if (userRepository.findAll() != null) {
			userRepository.save(user);
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to delete an existing user. Call the
	 * corresponding method of Respository interface.
	 */
	public boolean delete(User user) {
		if (userRepository.findAll() != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to list all users. Call the corresponding
	 * method of Respository interface.
	 */
	public List<User> list() {
		Iterable<User> userIter = userRepository.findAll();
		ArrayList<User> userList = new ArrayList<User>();
		userIter.forEach(user -> userList.add(user));
		return userList;
	}
	/*
	 * This method should be used to validate a user using password. Call the
	 * corresponding method of Respository interface.
	 */
	public boolean validate(String username, String password) {
		if (userRepository.validate(username, password) != null) {
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to get a user by username. Call the
	 * corresponding method of Respository interface.
	 */
	public Optional<User> get(String username) {
		return userRepository.findById(username);
	}
	/*
	 * This method is used to check whether a user with a specific username
	 * exists. Call the corresponding method of Respository interface.
	 */
	public boolean exists(String username) {
		return userRepository.existsById(username);
	}
}
