package com.cts.activitystream.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.activitystream.model.User;
import com.cts.activitystream.repository.UserRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn’t currently 
* provide any additional behavior over the @Component annotation, but it’s a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class UserServiceImpl implements UserService{

	/*
	 * Autowiring should be implemented for the UserRepository.
	 *  Please note that we should not create any object using the new keyword.
	 * */
	@Autowired
	UserRepository userRepository;	
	/*
	 * This method should be used to save a new user. Call the corresponding method of Respository interface.
	 * 
	 */
	public boolean save(User user) {
		userRepository.save(user);
		return true;
	}
	/*
	 * This method should be used to update an existing user. Call the corresponding method of Respository interface.
	 * 
	 */
	public boolean update(User user) {
		if (userRepository.findAll() != null) {
			userRepository.save(user);
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to delete an existing user. Call the corresponding method of Respository interface.
	 * 
	 */
	public boolean delete(User user) {
		if (userRepository.findAll() != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to list all users. Call the corresponding method of Respository interface.
	 * 
	 */
	public List<User> list() {
		Iterable<User> userIter = userRepository.findAll();
		ArrayList<User> userList = new ArrayList<User>();
		userIter.forEach(user -> userList.add(user));
		return userList;
	}
	/*
	 * This method should be used to validate a user using password. Call the corresponding method of Respository interface.
	 * 
	 */
	public boolean validate(String username, String password) {
		if (userRepository.validate(username, password) != null) {
			return true;
		}
		return false;
	}
	/*
	 * This method should be used to get a user by username. Call the corresponding method of Respository interface.
	 */
	public User get(String username) {
		return userRepository.findByUserName(username);
	}
	/*
	 * This method is used to check whether a user with a specific username exists. Call the corresponding method of Respository interface.
	 */
	public boolean exists(String username) {
		return userRepository.existsById(username);
	}
}
