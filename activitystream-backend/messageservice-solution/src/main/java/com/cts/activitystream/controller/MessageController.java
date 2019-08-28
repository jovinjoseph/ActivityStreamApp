package com.cts.activitystream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cts.activitystream.model.Message;
import com.cts.activitystream.service.MessageService;

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
public class MessageController {
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement nine functionalities regarding circles. They are
	 * as following:
	 * 
	 * 1. Send message to circle 2. Send message to users 3. Retrieve message
	 * from users 4. Retrieve message from circles 5. Retrieve all tags 6.
	 * Retrieve messages containing a specific tag 7. Subscribe a user to stream
	 * containing a specific tag 8. Unsubscribe a user from a stream containing
	 * a specific tag 9. Retrieve the set of tags subscribed by a specific user
	 * 
	 * we must also ensure that only a user who is logged in should be able to
	 * perform the functionalities mentioned above.
	 */

	/*
	 * Autowiring should be implemented for the MessageService. Please note that
	 * we should not create any object using the new keyword
	 */
	@Autowired
	private MessageService messageService;

	/*
	 * Define a handler method which will send a message to a circle by reading
	 * the Serialized message object from request body and save the message in
	 * message table in database. Please note that the loggedIn userID should be
	 * taken as the senderId for the message. This handler method should return
	 * any one of the status messages basis on different situations: 1. 200(OK)
	 * - If the message is sent successfully 2. 500(INTERNAL SERVER ERROR) - If
	 * the message could not be sent
	 * 
	 * This handler method should map to the URL
	 * "/api/message/sendMessageToCircle/{circleName}" using HTTP POST method"
	 * where "circleName" should be replaced by the destination circle name
	 * without {}
	 */
	@PostMapping(value = "/api/message/sendMessageToCircle/{circleName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> sendMessageToCircle(@PathVariable("circleName") String circleName,
			@RequestBody Message message/*, @RequestBody String loggedInuser*/, UriComponentsBuilder ucBuilder,
			HttpServletRequest request) {
/*		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();*/
		try {
			// message.setSenderName(loggedInuser);
			//message.setSenderName(userId);
			message.setPostedDate();
			if (messageService.sendMessageToCircle(circleName, message)) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 * Define a handler method which will send a message to an individual user
	 * by reading the Serialized message object from request body and save the
	 * message in message table in database. Please note that the loggedIn
	 * userID should be taken as the senderId for the message. This handler
	 * method should return any one of the status messages basis on different
	 * situations: 1. 200(OK) - If the message is sent successfully 2.
	 * 500(INTERNAL SERVER ERROR) - If the message could not be sent
	 * 
	 * This handler method should map to the URL
	 * "/api/message/sendMessageToUser/{receiverId}" using HTTP POST method"
	 * where "receiverId" should be replaced by the recipient user name without
	 * {}
	 */
	@PostMapping(value = "/api/message/sendMessageToUser/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> sendMessageToUser(@PathVariable("receiverId") String receiverId,
			@RequestBody Message message, UriComponentsBuilder ucBuilder, HttpServletRequest request) {
/*		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();*/
		try {
			// message.setSenderName(loggedInuser);
			//message.setSenderName(userId);
			message.setPostedDate();
			if (messageService.sendMessageToUser(receiverId, message)) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Define a handler method which will get all messages sent by a specific
	 * user to another specific user. Please note that there can be huge number
	 * of messages which has been transmitted between two users. Hence,
	 * retrieving messages partially will help to improve performance.
	 * Pagination can be implemented here. This handler method should return any
	 * one of the status messages basis on different situations: 1. 200(OK) - If
	 * the messages are retrieved successfully(provided that the messages exist)
	 * 
	 * This handler method should map to the URL
	 * "/api/message/getMessagesByUser/{senderUsername}/{receiverUserName}/{pageNumber}"
	 * using HTTP GET method" where "senderUsername" should be replaced by a
	 * valid user name without {} and "receiverUsername" should be replaced by a
	 * valid user name without {} and "pageNumber" should be replaced by the
	 * numeric page number that we are looking for without {}
	 */
	@GetMapping(value = "/api/message/getMessagesByUser/{senderUserName}/{receiverUserName}/{pageNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Message>> getMessagesByUser(@PathVariable("senderUserName") String senderUserName,
			@PathVariable("receiverUserName") String receiverUserName, @PathVariable("pageNumber") int pageNumber,
			HttpServletRequest request) {

		List<Message> messages = messageService.getMessagesFromUser(senderUserName, receiverUserName, pageNumber);

		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);

	}

	/*
	 * Define a handler method which will get all messages sent to a specific
	 * circle by all users. Please note that there can be huge number of
	 * messages which has been transmitted to a circle. Hence, retrieving
	 * messages partially will help to improve performance. Pagination can be
	 * implemented here. This handler method should return any one of the status
	 * messages basis on different situations: 1. 200(OK) - If the messages are
	 * retrieved(if the messages exist)
	 * 
	 * This handler method should map to the URL
	 * "/api/message/getMessagesByUser/{circleName}/{pageNumber}" using HTTP GET
	 * method" where "circleName" should be replaced by a valid user name
	 * without {} and "pageNumber" should be replaced by the numeric page number
	 * that we are looking for without {}
	 */
	@GetMapping(value = "/api/message/getMessagesByCircle/{circleName}/{pageNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Message>> getMessagesByCircle(@PathVariable("circleName") String circleName,
			@PathVariable("pageNumber") int pageNumber, HttpServletRequest request) {
		List<Message> messages = messageService.getMessagesFromCircle(circleName, pageNumber);
		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
	}


}