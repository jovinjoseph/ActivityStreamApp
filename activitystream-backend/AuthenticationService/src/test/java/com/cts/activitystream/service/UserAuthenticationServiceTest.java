package com.cts.activitystream.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.activitystream.domain.User;
import com.cts.activitystream.exceptions.UserAlreadyExistsException;
import com.cts.activitystream.exceptions.UserNotFoundException;
import com.cts.activitystream.repositories.UserAuthenticationRepository;
import com.cts.activitystream.services.UserAuthenticationServiceImpl;

public class UserAuthenticationServiceTest {

	@Mock
	private transient UserAuthenticationRepository userRepository;
	private transient User user;

	@InjectMocks
	private transient UserAuthenticationServiceImpl userServiceImpl;

	transient Optional<User> options;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User("test123", "testFirst", "testLast", "123456", new Date());
		options = Optional.of(user);
	}

	@Test
	public void testSaveSuccess() throws UserNotFoundException, UserAlreadyExistsException {
		when(userRepository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
		assertEquals("Cannot register user", true, flag);
		verify(userRepository, times(1)).save(user);

	}

	@Test(expected = UserAlreadyExistsException.class)
	public void testSaveFailure() throws UserAlreadyExistsException {
		when(userRepository.findById(user.getUsername())).thenReturn(options);
		when(userRepository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
		assertFalse("failed save", flag);
		verify(userRepository, times(1)).save(user);

	}

	@Test
	public void testValidateSuccess() throws UserNotFoundException {
		when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
		User userResult = userServiceImpl.findByUserIdAndPassword(user.getUsername(), user.getPassword());
		assertNotNull(userResult);
		assertEquals("test123", userResult.getUsername());
		verify(userRepository, times(1)).findByUsernameAndPassword(user.getUsername(), user.getPassword());

	}

	@Test(expected = UserNotFoundException.class)
	public void testValidateFailure() throws UserNotFoundException {
		when(userRepository.findById("test")).thenReturn(null);
		userServiceImpl.findByUserIdAndPassword(user.getUsername(), user.getPassword());
	}

}
