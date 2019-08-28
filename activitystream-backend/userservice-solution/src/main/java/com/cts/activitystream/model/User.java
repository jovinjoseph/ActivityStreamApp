package com.cts.activitystream.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * The class "User" will be acting as the data model for the user Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 *
 * Please note that you will have to use @Component annotation on this class if wish
 * to autowire the class from any other components of the application
 */
@Entity
@Component
@Table(name = "user")
public class User {

	/*
	 * This class should have three fields
	 * (username,name,password). Out of these three fields, the
	 * field username should be the primary key. This class should also contain
	 * the getters and setters for the fields.
	 */
	
	@Id
	private String username;

	@Column(name ="First_Name")
	private String firstName;
	
	@Column(name ="Last_Name")
	private String lastName;
	
	private String password;

	public User( String firstName, String lastName, String username, String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public User() {
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
