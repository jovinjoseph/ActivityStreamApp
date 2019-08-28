package com.cts.activitystream.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
/*
 * The class "Circle" will be acting as the data model for the circle Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 * 
 * Please note that you will have to use @Component annotation on this class if wish
 * to autowire the class from any other components of the application
 */
@Entity
@Component
@Table(name = "CIRCLE")
public class Circle {
	/*
	 * This class should have three fields
	 * (circleName,creatorId,createdDate). Out of these three fields, the
	 * field circleName should be the primary key. This class should also contain
	 * the getters and setters for the fields. The value of createdDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	@Id
	@Column(name = "circleName", updatable = false, nullable = false, unique=true)
	private String circleName;
	

	private String creatorId;
	
	private Timestamp createdDate;

	
	public Circle(String circleName, String creatorId, Timestamp createdDate) {
		this.circleName = circleName;
		this.creatorId = creatorId;
		this.createdDate = Timestamp.valueOf(LocalDateTime.now());
	}

	public Circle() {
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public void setCreatedDate() {
		this.createdDate = Timestamp.valueOf(LocalDateTime.now());
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCircleName() {
		return this.circleName;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}	
}