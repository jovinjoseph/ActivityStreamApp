package com.cts.activitystream.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.activitystream.UserServiceSpringBootApplication;
import com.cts.activitystream.config.JwtFilter;
import com.cts.activitystream.controller.UserAuthenticationController;
import com.cts.activitystream.controller.UserController;
import com.cts.activitystream.model.User;
import com.cts.activitystream.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceSpringBootApplication.class)
public class UserControllerTest {

	private MockMvc userMockMvc;
	private MockMvc userAuthMockMvc;

	@Mock
	private User user;

	/*@Mock
	private UserAuthenticationService userAuthenticationService;*/
	
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController = new UserController();

	@InjectMocks
	private JwtFilter jwtFilter = new JwtFilter();

	@InjectMocks
	private UserAuthenticationController userAuthenticateController = new UserAuthenticationController();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userMockMvc = MockMvcBuilders.standaloneSetup(userController).addFilters(jwtFilter).build();

	}

	@Test
	public void testGetAllUsers() throws Exception {

		List<User> users = Arrays.asList(new User("John", "Paul", "john", "password"), new User("Chris","Jordan","chris", "password2"));

		when(userService.list()).thenReturn(users);

		userMockMvc.perform(get("/api/user/").header("Authorization", "Bearer " + getToken())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].username", is("john")))
				.andExpect(jsonPath("$[0].firstName", is("John"))).andExpect(jsonPath("$[0].password", is("password")))
				.andExpect(jsonPath("$[1].username", is("chris"))).andExpect(jsonPath("$[1].firstName", is("Chris")))
				.andExpect(jsonPath("$[1].password", is("password2")));
		verify(userService, times(1)).list();
	}

	@Test
	public void testGetSpecificUser() throws Exception {

		User user = new User("John", "Paul", "john", "password");

		when(userService.get("john")).thenReturn(user);

		userMockMvc.perform(get("/api/user/john").header("Authorization", "Bearer " + getToken()))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.username", is("john"))).andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.password", is("password")));

	}

	@Test
	public void testCreateNewUser() throws Exception {

		User user = new User("John", "Paul", "john", "password");
		when(userService.get("john")).thenReturn(null);

		userMockMvc
				.perform(post("/api/user/").header("Authorization", "Bearer " + getToken())
						.contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.username", is("john")))
				.andExpect(jsonPath("$.firstName", is("John"))).andExpect(jsonPath("$.password", is("password")));
		
		

	}

	@Test
	public void testCreateNewUserFailure() throws Exception {

		User user = new User("John", "Paul", "john", "password");

		when(userService.get("john")).thenReturn(user);

		userMockMvc
				.perform(post("/api/user/").header("Authorization", "Bearer " + getToken())
						.contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isConflict());

	}

	@Test
	public void testUpdateExistingUser() throws Exception {

		User user = new User("John", "Paul", "john", "password");

		when(userService.get(user.getUsername())).thenReturn(user);

		User updatedUser = new User("John", "Paul", "john", "password2");
		when(userService.get(updatedUser.getUsername())).thenReturn(updatedUser);

		userMockMvc
				.perform(put("/api/user/john").header("Authorization", "Bearer " + getToken())
						.contentType(MediaType.APPLICATION_JSON).content(asJsonString(updatedUser)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.username", is("john")))
				.andExpect(jsonPath("$.firstName", is("John"))).andExpect(jsonPath("$.password", is("password2")));

	}

	@Test
	public void testUpdateInvalidUser() throws Exception {

		User updatedUser = new User("John", "Paul", "john", "password");
		when(userService.get("john")).thenReturn(user);

		userMockMvc
				.perform(put("/api/user/john2").header("Authorization", "Bearer " + getToken())
						.contentType(MediaType.APPLICATION_JSON).content(asJsonString(updatedUser)))
				.andExpect(status().isNotFound());
	}

	/*
	 * converts a Java object into JSON representation
	 */

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * 
	 * Does authentication and return back token
	 */

	public String getToken() throws Exception {
		userAuthMockMvc = MockMvcBuilders.standaloneSetup(userAuthenticateController).build();
		String userName = "john";
		String password = "password";
		User user = new User("John", "Paul", userName, password);
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huMTIzIiwiaWF0IjoxNTI4ODM3Nzc3fQ.KW3Ix8g3PLKTrdCbYcZ0_61pz_xNwjgXWLLiC0ICwl0";
		// when(userService.get(userName)).thenReturn(null);
		when(userService.validate(userName, password)).thenReturn(true);

		MvcResult result = userAuthMockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				// .andExpect(status().isOk())
				.andReturn();
		String responseOutput = result.getResponse().getContentAsString();
		String parseToken = "\"token\":\"";
/*		String token = responseOutput.substring(responseOutput.indexOf(parseToken) + parseToken.length(),
				responseOutput.length() - 2);*/
		System.out.println("Token:" + token);
		return token;
	}
}
