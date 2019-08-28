package com.cts.activitystream.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
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

import com.cts.activitystream.CircleServiceSpringBootApplication;
import com.cts.activitystream.config.JwtFilter;
import com.cts.activitystream.controller.CircleController;
import com.cts.activitystream.controller.UserAuthenticationController;
import com.cts.activitystream.domain.User;
import com.cts.activitystream.model.Circle;
import com.cts.activitystream.service.CircleService;
import com.cts.activitystream.services.UserAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CircleServiceSpringBootApplication.class)
public class CircleControllerTest {

	@Mock
	private User user;
	
	@Mock
	private UserAuthenticationService userService;
	
	@InjectMocks
	private UserAuthenticationController userAuthenticateController = new UserAuthenticationController();
	
	@InjectMocks
	private JwtFilter jwtFilter = new JwtFilter();
	
	private MockMvc circleMockMvc;
	private MockMvc userAuthMockMvc;
	
	
	@Mock
	private Circle circle;
	
	@Mock
	private CircleService circleService;
	
	@InjectMocks
	private CircleController circleController=new CircleController();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		circleMockMvc=MockMvcBuilders.standaloneSetup(circleController).addFilters(jwtFilter)
				.build();
			
	}
	
	@Test
    public void testCreateCircle() throws Exception {
		
		Circle newCircle=new Circle("Spring", "john", null);
		when(circleService.get(anyString())).thenReturn(null);
		when(circleService.save((Circle)any())).thenReturn(true);
		
        circleMockMvc.perform(post("/api/circle")
        		 .header("Authorization", "Bearer " + getToken())
        		 .contentType(MediaType.APPLICATION_JSON)
                 .content(asJsonString(newCircle)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.circleName", is("Spring")))
                .andExpect(jsonPath("$.creatorId", is("john")));
        verify(circleService, times(1)).save((Circle)any());
        verify(circleService, times(1)).get(anyString());
    }
	
	
	@Test
    public void testCreateDuplicateCircleFailure() throws Exception {
			
		
		Circle newCircle=new Circle("Spring", null, null);
		
		when(circleService.get(newCircle.getCircleName())).thenReturn(newCircle);
        
		circleMockMvc.perform(post("/api/circle")
				 .header("Authorization", "Bearer " + getToken())
        		 .contentType(MediaType.APPLICATION_JSON)
                 .content(asJsonString(newCircle)))
                .andExpect(status().isConflict())
                ;
        verify(circleService, times(1)).get(newCircle.getCircleName());
        verify(circleService, times(0)).save(newCircle);
    }
	
	
	
	@Test
    public void testGetAllCircles() throws Exception {
				
		List<Circle> circles=Arrays.asList(
				new Circle("Angular","john",new Timestamp(System.currentTimeMillis())),
				new Circle("Spring","chris",new Timestamp(System.currentTimeMillis())));
		
		when(circleService.getAllCircles()).thenReturn(circles);
		
        circleMockMvc.perform(get("/api/circle")
        		.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].circleName", is("Angular")))
                .andExpect(jsonPath("$[0].creatorId", is("john")))
                .andExpect(jsonPath("$[1].circleName", is("Spring")))
                .andExpect(jsonPath("$[1].creatorId", is("chris")));
        verify(circleService, times(1)).getAllCircles(); 
    }
	
	@Test
    public void testGetAllCirclesFailure() throws Exception {
		
		
		verifyZeroInteractions(circleService);
    }
	
	
	@Test
    public void testGetAllMatchingCircles() throws Exception {
			
		List<Circle> circles=Arrays.asList(
				new Circle("Spring","chris",new Timestamp(System.currentTimeMillis())),
				new Circle("Spring Security","chris",new Timestamp(System.currentTimeMillis())));
		
	
		when(circleService.getAllCircles("spring")).thenReturn(circles);
		
        circleMockMvc.perform(get("/api/circle/search/spring")
        		.header("Authorization", "Bearer " + getToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].circleName", is("Spring")))
                .andExpect(jsonPath("$[0].creatorId", is("chris")))
                .andExpect(jsonPath("$[1].circleName", is("Spring Security")))
                .andExpect(jsonPath("$[1].creatorId", is("chris")));
        verify(circleService, times(1)).getAllCircles(("spring")); 
    }
	
	@Test
    public void testGetAllMatchingCirclesFailure() throws Exception {
     
        verifyZeroInteractions(circleService);
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
		String username = "john";
		String password = "password";
		String firstName = "John";
		String lastName = "Paul";
		Date created = null;
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huMTIzIiwiaWF0IjoxNTI4ODM3Nzc3fQ.KW3Ix8g3PLKTrdCbYcZ0_61pz_xNwjgXWLLiC0ICwl0";
		
		
		User user = new User(username, firstName, lastName, password, created);
		
		when(userService.get(username)).thenReturn(null);
		when(userService.validate(username, password)).thenReturn(true);
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
