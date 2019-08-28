package com.cts.activitystream.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspectUserCircle {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectUserCircle.class);
	/*Write loggers for each of the methods of REST controller, 
    any particular method will have all the four aspectJ annotation
    (@Before, @After, @AfterReturning, @AfterThrowing).*/
	@Before("execution(* com.cts.activitystream.controller.UserCircleController.addUsertoCircle(..))")
	public void logBeforeAddUsertoCircle(JoinPoint joinPoint) {
	        LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserCircleController.addUsertoCircle(..))")
	public void logAfterAddUsertoCircle(JoinPoint joinPoint) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.addUsertoCircle(..))", returning = "result")
	public void logAfterReturningAddUsertoCircle(JoinPoint joinPoint, Object result) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.addUsertoCircle(..))", throwing = "error")
	public void logAfterThrowingAddUsertoCircle(JoinPoint joinPoint, Throwable error) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    LOGGER.debug("Exception : " + error);
	}
	/*AOP methods for removeUserFromCircle method - UserCircleController*/
	@Before("execution(* com.cts.activitystream.controller.UserCircleController.removeUserFromCircle(..))")
	public void logBeforeRemoveUserFromCircle(JoinPoint joinPoint) {
	        LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserCircleController.removeUserFromCircle(..))")
	public void logAfterRemoveUserFromCircle(JoinPoint joinPoint) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.removeUserFromCircle(..))", returning = "result")
	public void logAfterReturningRemoveUserFromCircle(JoinPoint joinPoint, Object result) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.removeUserFromCircle(..))", throwing = "error")
	public void logAfterThrowingRemoveUserFromCircle(JoinPoint joinPoint, Throwable error) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    LOGGER.debug("Exception : " + error);
	}
	/*AOP methods for getUser method - UserController*/
	@Before("execution(* com.cts.activitystream.controller.UserCircleController.getUserCircles(..))")
	public void logBeforeGetUserCircles(JoinPoint joinPoint) {
	        LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserCircleController.getUserCircles(..))")
	public void logAfterGetUserCircles(JoinPoint joinPoint) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.getUserCircles(..))", returning = "result")
	public void logAfterReturningGetUserCircles(JoinPoint joinPoint, Object result) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserCircleController.getUserCircles(..))", throwing = "error")
	public void logAfterThrowingGetUserCircles(JoinPoint joinPoint, Throwable error) {
	    LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	    LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    LOGGER.debug("Exception : " + error);
	}
  
		
}