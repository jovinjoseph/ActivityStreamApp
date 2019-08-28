package com.cts.activitystream.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.activitystream.domain.User;

public interface UserAuthenticationRepository extends CrudRepository<User, String> {

	User findByUsernameAndPassword(String username, String password);

	@Query("select u from User u where u.username = :username")
	User findByUserName(@Param("username") String username);

	/*
	 * This method will validate a user from User table by username and
	 * password.
	 * 
	 * Write query to validate user using username and password. For example
	 * : @Query("select u from User u where u.username = (?1) and u.password = (?2)"
	 * )
	 */
	@Query("select u from User u where u.username = :username and u.password = :password")
	User validate(@Param("username") String username, @Param("password") String password);
}
