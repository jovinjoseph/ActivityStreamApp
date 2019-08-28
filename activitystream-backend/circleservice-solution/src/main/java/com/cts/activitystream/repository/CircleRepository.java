package com.cts.activitystream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.activitystream.model.Circle;
/*
* This class is implementing the JpaRepository interface for Circle.
* */
public interface CircleRepository extends JpaRepository<Circle, String>{
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
	* This method will search for all circles in data source which are matching
	* the search string. 
	* 
	* Write query to find all circles matching with search string.
	* */
	
	@Query("select u from Circle u where u.circleName like %:searchString%")
	List<Circle> findAll(@Param("searchString") String searchString);
	
	@Query
	public Circle findByCircleName(String circleName);
	
	@Query
	public Circle findByCreatorId(String creatorId);
	
}