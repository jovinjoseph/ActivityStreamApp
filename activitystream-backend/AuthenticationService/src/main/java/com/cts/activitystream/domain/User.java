package com.cts.activitystream.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String username;
	
	@Column(name ="First_Name")
	private String firstName;
	
	@Column(name ="Last_Name")
	private String lastName;
	
	@Column(name ="password")
	private String password;
	
	@CreationTimestamp
	@Column(name ="created_date")
	private Timestamp created;

	public User(String username, String firstName, String lastName, String password, Date created) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.created = Timestamp.valueOf(LocalDateTime.now());
	}

	public User() {
		super();
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated() {
		this.created = Timestamp.valueOf(LocalDateTime.now());
	}
	
	

}
