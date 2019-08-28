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
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectUser {
	private static final Logger logger = LoggerFactory
			.getLogger(LoggingAspectUser.class);

	/*
	 * Write loggers for each of the methods of REST controllers, any particular
	 * method will have all the four aspectJ annotation (@Before, @After,
	 * @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.controller.UserController.listAllUsers(..))")
	public void logBeforeListAllUsers(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserController.listAllUsers(..))")
	public void logAfterListAllUsers(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserController.listAllUsers(..))", returning = "result")
	public void logAfterReturningListAllUsers(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserController.listAllUsers(..))", throwing = "error")
	public void logAfterThrowingListAllUsers(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for getUser method - UserController */
	@Before("execution(* com.cts.activitystream.controller.UserController.getUser(..))")
	public void logBeforeGetUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserController.getUser(..))")
	public void logAfterGetUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserController.getUser(..))", returning = "result")
	public void logAfterReturningGetUser(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserController.getUser(..))", throwing = "error")
	public void logAfterThrowingGetUser(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for createUser method - UserController */
	@Before("execution(* com.cts.activitystream.controller.UserController.createUser(..))")
	public void logBeforeCreateUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserController.createUser(..))")
	public void logAfterCreateUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserController.createUser(..))", returning = "result")
	public void logAfterReturningCreateUser(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserController.createUser(..))", throwing = "error")
	public void logAfterThrowingCreateUser(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for updateUser method - UserController */
	@Before("execution(* com.cts.activitystream.controller.UserController.updateUser(..))")
	public void logBeforeUpdateUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.UserController.updateUser(..))")
	public void logAfterListUpdateUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.UserController.updateUser(..))", returning = "result")
	public void logAfterReturningUpdateUser(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.UserController.updateUser(..))", throwing = "error")
	public void logAfterThrowingUpdateUser(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}
}