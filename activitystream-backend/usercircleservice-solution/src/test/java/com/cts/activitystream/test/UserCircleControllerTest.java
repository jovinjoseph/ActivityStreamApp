package com.cts.activitystream.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

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

import com.cts.activitystream.UserCircleServiceSpringBootApplication;
import com.cts.activitystream.config.JwtFilter;
import com.cts.activitystream.controller.UserAuthenticationController;
import com.cts.activitystream.controller.UserCircleController;
import com.cts.activitystream.domain.User;
import com.cts.activitystream.model.UserCircle;
import com.cts.activitystream.service.UserCircleService;
import com.cts.activitystream.services.UserAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=UserCircleServiceSpringBootApplication.class)
public class UserCircleControllerTest {

	@Mock
	private User user;
	
	@Mock
	private UserAuthenticationService userService;
	
	@InjectMocks
	private UserAuthenticationController userAuthenticateController = new UserAuthenticationController();
	
	@InjectMocks
	private JwtFilter jwtFilter = new JwtFilter();
	
	private MockMvc userCircleMockMvc;
	private MockMvc userAuthMockMvc;
	
	
	@Mock
	private UserCircleService userCircleService;
	
	@InjectMocks
	private UserCircleController userCircleController=new UserCircleController();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userCircleMockMvc=MockMvcBuilders.standaloneSetup(userCircleController).addFilter(jwtFilter)
				.build();
	}
	
	@Test
    public void testAddUserToCircle() throws Exception {
		
		@SuppressWarnings("unused")
		UserCircle userCircle=new UserCircle("john", "Spring");
		
		when(userCircleService.get("john", "spring")).thenReturn(null);
		when(userCircleService.addUser("john", "spring")).thenReturn(true);
		
		userCircleMockMvc.perform(put("/api/usercircle/addToCircle/john/spring")
				.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isOk());
          
        verify(userCircleService, times(1)).get("john", "spring");
        verify(userCircleService, times(1)).addUser("john", "spring");
    }
	
	@Test
    public void testAddUserToCircleDuplicateFailure() throws Exception {
		
		
		UserCircle userCircle=new UserCircle("john", "Spring");
		
	
		when(userCircleService.get("john", "spring")).thenReturn(userCircle);
		when(userCircleService.addUser("john", "spring")).thenReturn(true);
		
		userCircleMockMvc.perform(put("/api/usercircle/addToCircle/john/spring")
				.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isConflict());
                
        verify(userCircleService, times(1)).get("john", "spring");
        verify(userCircleService, times(0)).addUser("john", "spring");
    }
	
	
	
	
	
	
	@Test
    public void testRemoveUserFromCircle() throws Exception {
		
		@SuppressWarnings("unused")
		UserCircle userCircle=new UserCircle("john", "Spring");
		
		when(userCircleService.get("john", "spring")).thenReturn(null);
		when(userCircleService.removeUser("john", "spring")).thenReturn(true);
		
		userCircleMockMvc.perform(put("/api/usercircle/removeFromCircle/john/spring")
				.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isOk());
                
        verify(userCircleService, times(0)).get("john", "spring");
        verify(userCircleService, times(1)).removeUser("john", "spring");
    }
	
	@Test
    public void testRemoveUserFromCircleFailure() throws Exception {
		
		@SuppressWarnings("unused")
		UserCircle userCircle=new UserCircle("john", "Spring");
		
		
		when(userCircleService.get("john", "spring")).thenReturn(null);
		when(userCircleService.removeUser("john", "spring")).thenReturn(false);
		
		userCircleMockMvc.perform(put("/api/usercircle/removeFromCircle/john/spring")
				.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isInternalServerError());
                
        
        verify(userCircleService, times(1)).removeUser("john", "spring");
    }
	
	
	@Test
    public void testUserSubscriptionToCircle() throws Exception {
		
		
		@SuppressWarnings("unused")
		UserCircle userCircle=new UserCircle("john", "Spring");
		
		
		when(userCircleService.getMyCircles("john")).thenReturn(Arrays.asList("Spring","Angular"));
		
		userCircleMockMvc.perform(get("/api/usercircle/searchByUser/john")
				.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isOk());
               
        verify(userCircleService, times(1)).getMyCircles("john");
    }
	
	
	@Test
    public void testUserSubscriptionToCircleFailure() throws Exception {
		
		@SuppressWarnings("unused")
		UserCircle userCircle=new UserCircle("john", "Spring");
		
		
		when(userCircleService.getMyCircles("john")).thenReturn(Arrays.asList("Spring","Angular"));
		
        verify(userCircleService, times(0)).getMyCircles("john");
    }
	
	
     /*converts a Java object into JSON representation*/
     
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
	/*	String token = responseOutput.substring(responseOutput.indexOf(parseToken) + parseToken.length(),
				responseOutput.length() - 2);*/
		System.out.println("Token:" + token);
		return token;
	}
}
