package com.cts.activitystream.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

import com.cts.activitystream.MessageServiceSpringBootApplication;
import com.cts.activitystream.config.JwtFilter;
import com.cts.activitystream.controller.MessageController;
import com.cts.activitystream.controller.UserAuthenticationController;
import com.cts.activitystream.model.Message;
import com.cts.activitystream.domain.User;
import com.cts.activitystream.service.MessageService;
import com.cts.activitystream.services.UserAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MessageServiceSpringBootApplication.class)
public class MessageControllerTest {

	@Mock
	private User user;
	
	@Mock
	private UserAuthenticationService userService;
	
	@InjectMocks
	private UserAuthenticationController userAuthenticateController = new UserAuthenticationController();
	
	@InjectMocks
	private JwtFilter jwtFilter = new JwtFilter();
	
	private MockMvc messageMockMvc;
	private MockMvc userAuthMockMvc;

	@Mock
	private Message message;

	@Mock
	private MessageService messageService;

	@InjectMocks
	private MessageController messageController = new MessageController();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		messageMockMvc = MockMvcBuilders.standaloneSetup(messageController).addFilter(jwtFilter).build();

	}

	@Test
	public void testSendMessageToCircle() throws Exception {

		Message newMessage = new Message("john", null, null, null, "text", "Sample Message", null);

		when(messageService.sendMessageToCircle(anyString(), any())).thenReturn(true);

		messageMockMvc
				.perform(post("/api/message/sendMessageToCircle/spring")
						.header("Authorization", "Bearer " + getToken())
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newMessage)))

				.andExpect(status().isOk());

		verify(messageService, times(1)).sendMessageToCircle(anyString(), any());
	}

	@Test
	public void testSendMessageToCircleFailure() throws Exception {

		Message newMessage = new Message("john", null, null, null, "text", "Sample Message", null);

		when(messageService.sendMessageToCircle(anyString(), any())).thenReturn(false);

		messageMockMvc.perform(post("/api/message/sendMessageToCircle/spring")
				.header("Authorization", "Bearer " + getToken())
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newMessage))).andExpect(status().isInternalServerError());

		verify(messageService, times(1)).sendMessageToCircle(anyString(), any());
	}

	@Test
	public void testSendMessageToUser() throws Exception {

		Message newMessage = new Message("john", "chris", null, null, "text", "Hello!", null);

		when(messageService.sendMessageToUser(anyString(), any())).thenReturn(true);

		messageMockMvc.perform(post("/api/message/sendMessageToUser/chris")
				.header("Authorization", "Bearer " + getToken())
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newMessage))).andExpect(status().isOk());

		verify(messageService, times(1)).sendMessageToUser(anyString(), any());
	}

	@Test
	public void testSendMessageToUserFailure() throws Exception {

		Message newMessage = new Message("john", "chris", null, null, "text", "Hello!", null);

		when(messageService.sendMessageToUser(anyString(), any())).thenReturn(false);

		messageMockMvc.perform(post("/api/message/sendMessageToUser/chris")
				.header("Authorization", "Bearer " + getToken())
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newMessage))).andExpect(status().isInternalServerError());

		verify(messageService, times(1)).sendMessageToUser(anyString(), any());
	}

	@Test
	public void testGetMessagesByUser() throws Exception {

		List<Message> messages = Arrays.asList(new Message("john", "chris", null, null, "text", "First Message", null),
				new Message("john", "chris", null, null, "text", "Second Message", null),
				new Message("john", "chris", null, null, "text", "Third Message", null));

		when(messageService.getMessagesFromUser(anyString(), anyString(), anyInt())).thenReturn(messages);

		messageMockMvc.perform(get("/api/message/getMessagesByUser/john/chris/1")
				.header("Authorization", "Bearer " + getToken()))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].senderName", is("john"))).andExpect(jsonPath("$[0].receiverId", is("chris")))
				.andExpect(jsonPath("$[0].streamType", is("text")))
				.andExpect(jsonPath("$[0].message", is("First Message")))
				.andExpect(jsonPath("$[1].senderName", is("john"))).andExpect(jsonPath("$[1].receiverId", is("chris")))
				.andExpect(jsonPath("$[1].streamType", is("text")))
				.andExpect(jsonPath("$[1].message", is("Second Message")))
				.andExpect(jsonPath("$[2].senderName", is("john"))).andExpect(jsonPath("$[2].receiverId", is("chris")))
				.andExpect(jsonPath("$[2].streamType", is("text")))
				.andExpect(jsonPath("$[2].message", is("Third Message")));

		verify(messageService, times(1)).getMessagesFromUser(anyString(), anyString(), anyInt());
	}

	@Test
	public void testGetMessagesByUserFailure() throws Exception {

		@SuppressWarnings("unused")
		List<Message> messages = Arrays.asList(new Message("john", "chris", null, null, "text", "First Message", null),
				new Message("john", "chris", null, null, "text", "Second Message", null),
				new Message("john", "chris", null, null, "text", "Third Message", null));

		when(messageService.getMessagesFromUser(anyString(), anyString(), anyInt())).thenReturn(null);

		verify(messageService, times(0)).getMessagesFromUser(anyString(), anyString(), anyInt());
	}

	@Test
	public void testGetMessagesByCircle() throws Exception {

		List<Message> messages = Arrays.asList(new Message("john", null, "Spring", null, "text", "First Message", null),
				new Message("john", null, "Spring", null, "text", "Second Message", null),
				new Message("john", null, "Spring", null, "text", "Third Message", null));

		when(messageService.getMessagesFromCircle(anyString(), anyInt())).thenReturn(messages);

		messageMockMvc.perform(get("/api/message/getMessagesByCircle/spring/1")
				.header("Authorization", "Bearer " + getToken()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].senderName", is("john")))
				.andExpect(jsonPath("$[0].circleName", is("Spring"))).andExpect(jsonPath("$[0].streamType", is("text")))
				.andExpect(jsonPath("$[0].message", is("First Message")))
				.andExpect(jsonPath("$[1].senderName", is("john"))).andExpect(jsonPath("$[1].circleName", is("Spring")))
				.andExpect(jsonPath("$[1].streamType", is("text")))
				.andExpect(jsonPath("$[1].message", is("Second Message")))
				.andExpect(jsonPath("$[2].senderName", is("john"))).andExpect(jsonPath("$[2].circleName", is("Spring")))
				.andExpect(jsonPath("$[2].streamType", is("text")))
				.andExpect(jsonPath("$[2].message", is("Third Message")));

		verify(messageService, times(1)).getMessagesFromCircle(anyString(), anyInt());
	}

	@Test
	public void testGetMessagesByCircleFailure() throws Exception {

		List<Message> messages = Arrays.asList(new Message("john", null, "Spring", null, "text", "First Message", null),
				new Message("john", null, "Spring", null, "text", "Second Message", null),
				new Message("john", null, "Spring", null, "text", "Third Message", null));

		when(messageService.getMessagesFromCircle(anyString(), anyInt())).thenReturn(messages);

		verify(messageService, times(0)).getMessagesFromCircle(anyString(), anyInt());
	}

	
	/* converts a Java object into JSON representation */

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
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huMTIzIiwiaWF0IjoxNTI4ODM3Nzc3fQ.KW3Ix8g3PLKTrdCbYcZ0_61pz_xNwjgXWLLiC0ICwl0";
		User user = new User(userName, "John", "Paul",password, Timestamp.valueOf(LocalDateTime.now()));
		when(userService.get(userName)).thenReturn(null);
		when(userService.validate(userName, password)).thenReturn(true);
		MvcResult result = userAuthMockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andReturn();
		String responseOutput = result.getResponse().getContentAsString();
		String parseToken = "\"token\":\"";
//		String token = responseOutput.substring(responseOutput.indexOf(parseToken) + parseToken.length(),
//				responseOutput.length() - 2);
		System.out.println("Token:" + token);
		return token;
	}
}
