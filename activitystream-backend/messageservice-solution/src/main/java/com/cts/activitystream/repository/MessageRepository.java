package com.cts.activitystream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.activitystream.model.Message;
/*
* This class is implementing the JpaRepository interface for Message.
* */
public interface MessageRepository extends CrudRepository<Message, Integer>{
	/*
	* Apart from the standard CRUD methods already available in JPA Repository, based
	* on our requirements, we might need to create few query methods for getting 
	* specific data from the datasource. Please annotate these methods with @Query 
	* annotation. We can configure the invoked database query by annotating the 
	* query method with the @Query annotation. It supports both JPQL and SQL queries,
	*  and the query that is specified by using the @Query annotation precedes all 
	*  other query generation strategies.
	* */
	
	/*
	* This method will retrieve all messages in database which are posted on the
	* specific circle specified in the method parameter. The messages should come
	* ordered by postedDate in descending order.
	* 
	* Write a query to retrieve all messages from database posted on specific circle.
	* */
	@Query("select u from Message u where u.circleName=:circleName")
	public List<Message> getMessagesFromCircle(@Param("circleName") String circleName);
	
	
	/*
	* This method will retrieve all messages in database which are sent between two
	* specific users specified in the method parameters. The messages should come
	* ordered by postedDate in descending order
	* 
	* Write a query to retrieve all messages from the database send between two specified users. 
	* */
	@Query("select u from Message u where u.senderName = :username and u.receiverId = :otherUsername")
	public List<Message> getMessagesFromUser(@Param("username") String username,
			@Param("otherUsername") String otherUsername);
	
	
}