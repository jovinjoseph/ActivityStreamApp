package com.cts.activitystream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.activitystream.model.Circle;
import com.cts.activitystream.repository.CircleRepository;
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
public class CircleServiceImpl implements CircleService{
	
	/*
	 * Autowiring should be implemented for the CircleRepository and UserRepository.
	 *  Please note that we should not create any object using the new keyword
	 * */
	@Autowired
	private CircleRepository circleRepository;
	/*
	 * A circle should only be created if the circle does not already exist or the creatorId
	 * is a valid username. 
	 * */
	@Transactional
	@Override
	public boolean save(Circle circle) {
		if (circleRepository.findByCircleName(circle.getCircleName()) == null) {
			circleRepository.save(circle);
			return true;
		}
		return false;
	}
	
	/*
	 * This method should return the list of existing circles
	 * */
	@Transactional
	@Override
	public List<Circle> getAllCircles() {
		return circleRepository.findAll();
	}
	
	/*
	 * This method should return the list of existing circles which matches the 
	 * search String
	 * */
	@Transactional
	@Override
	public List<Circle> getAllCircles(String searchString) {

		return circleRepository.findAll(searchString);
	}
	
	/*
	 * This method should return a specific circle which matches the Circle Name
	 */
	@Transactional
	@Override
	public Circle get(String circleName) {

		return circleRepository.findByCircleName(circleName);
	}
	
	/*
	 * This method should delete a specific circle(if exists)
	 */
	@Transactional
	@Override

	public boolean delete(Circle circle) {
		if (get(circle.getCircleName()) != null) {
			circleRepository.delete(circle);
			return true;
		}
		return false;
	}
		
}