package com.cts.activitystream.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 * 
 * Please note that you will have to use @Component annotation on this class if wish
 * to autowire the class from any other components of the application
 */
@Entity
@Component
@Table(name = "MESSAGE")
public class Message {
	/*
	 * This class should have eight fields
	 * (messageId,senderName,receiverId,circleName,postedDate,streamType,message,tag). Out of these eight fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;

	// To hold sender name
	private String senderName;

	// To hold receiver Id
	private String receiverId;

	// To hold circle Name
	private String circleName;

	// To save message posted date
	@Column(name = "POSTED_DATE")
	private Timestamp postedDate;

	// To hold stream type
	private String streamType;

	// To hold message text
	private String message;

	// To hold tag
	private String tag;
	
	public Message(){

	}

	public Message(String senderName, String receiverId, String circleName, Timestamp postedDate, String streamType,
			String message, String tag) {
		this.senderName = senderName;
		this.receiverId = receiverId;
		this.circleName = circleName;
		this.postedDate = Timestamp.valueOf(LocalDateTime.now());
		this.streamType = streamType;
		this.message = message;
		this.tag = tag;
	}

	public void setMessage(String message) {
		this.message = message;

	}

	public void setStreamType(String streamType) {
		this.streamType = streamType;

	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getMessageId() {
		return this.messageId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getCircleName() {
		return this.circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public Timestamp getPostedDate() {
		return this.postedDate;
	}

	public void setPostedDate() {
		this.postedDate = Timestamp.valueOf(LocalDateTime.now());
	}

	public String getSenderName() {
		return this.senderName;
	}

	public String getStreamType() {
		return this.streamType;
	}

	public String getMessage() {
		return this.message;
	}

	public String getTag() {
		return this.tag;
	}
}