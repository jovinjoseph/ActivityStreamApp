package com.cts.activitystream.service;

import java.util.List;

import com.cts.activitystream.model.Message;

public interface MessageService {
	/* You Should not modify this interface.  You have to implement these methods in corresponding Impl class*/
	public List<Message> getMessagesFromCircle(String circleName,int pageNumber);
	
	public List<Message> getMessagesFromUser(String username,String otherUsername,int pageNumber);
	
	public boolean sendMessageToCircle(String circleName,Message message);
	 
	public boolean sendMessageToUser(String username,Message message);
	
}
