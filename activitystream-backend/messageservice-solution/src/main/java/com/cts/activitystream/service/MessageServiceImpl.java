package com.cts.activitystream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.activitystream.model.Message;
import com.cts.activitystream.repository.MessageRepository;

/*
 * Service classes are used here to implement additional business logic/validation. 
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn’t currently 
 * provide any additional behavior over the @Component annotation, but it’s a good idea 
 * to use @Service over @Component in service-layer classes because it specifies intent 
 * better. Additionally, tool support and additional behavior might rely on it in the 
 * future.
 * */
@Service
public class MessageServiceImpl implements MessageService {

	/*
	 * Autowiring should be implemented for the UserTag, UserTagRepository,
	 * MessageRepository. Please note that we should not create any object using
	 * the new keyword
	 */
	@Autowired
	private MessageRepository messageRepository;

	/*
	 * This method should be used to get all messages from a specific circle.
	 * Call the corresponding method of Respository interface.
	 */
	public List<Message> getMessagesFromCircle(String circleName, int pageNumber) {
		return messageRepository.getMessagesFromCircle(circleName);
	}

	/*
	 * This method should be used to get all messages from a specific user to
	 * another specific user. Call the corresponding method of Respository
	 * interface.
	 */
	public List<Message> getMessagesFromUser(String username,
			String otherUsername, int pageNumber) {
		List<Message> messageFromList = messageRepository.getMessagesFromUser(username, otherUsername); 
		List<Message> messageToList = messageRepository.getMessagesFromUser(otherUsername,username);
		
		List<Message> combinedMessageList = messageFromList ;
		
		combinedMessageList.addAll(messageToList);
		combinedMessageList.sort((o1,o2) ->o1.getPostedDate().compareTo(o2.getPostedDate()));
		
		return combinedMessageList;

	}

	/*
	 * This method should be used to send messages to a specific circle. Please
	 * validate whether the circle exists and whether the sender is subscribed
	 * to the circle. Call the corresponding method of Respository interface.
	 */
	public boolean sendMessageToCircle(String circleName, Message message) {
		message.setCircleName(circleName);
		messageRepository.save(message);
		return true;
	}

	/*
	 * This method should be used to send messages to a specific user. Please
	 * validate whether the sender and receiver are valid users. Call the
	 * corresponding method of Respository interface.
	 */
	public boolean sendMessageToUser(String username, Message message) {

		message.setReceiverId(username);
		messageRepository.save(message);
		return true;
	}


}