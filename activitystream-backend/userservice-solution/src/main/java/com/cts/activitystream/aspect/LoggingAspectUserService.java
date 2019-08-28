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
public class LoggingAspectUserService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggingAspectUserService.class);

	/*
	 * Write loggers for each of the methods of UserServiceImpl, any particular
	 * method will have all the four aspectJ annotation (@Before, @After,
	 * @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.get(..))")
	public void logBeforeGetUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.get(..))")
	public void logAfterGetUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.get(..))", returning = "result")
	public void logAfterReturningGetUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.get(..))", throwing = "error")
	public void logAfterThrowingGetUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.save(..))")
	public void logBeforeSaveUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.save(..))")
	public void logAfterSaveUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.save(..))", returning = "result")
	public void logAfterReturningSaveUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.save(..))", throwing = "error")
	public void logAfterThrowingSaveUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.update(..))")
	public void logBeforeUpdateUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.update(..))")
	public void logAfterUpdateUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.update(..))", returning = "result")
	public void logAfterReturningUpdateUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.update(..))", throwing = "error")
	public void logAfterThrowingUpdateUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.delete(..))")
	public void logBeforeDeleteUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.delete(..))")
	public void logAfterDeleteUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.delete(..))", returning = "result")
	public void logAfterReturningDeleteUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.delete(..))", throwing = "error")
	public void logAfterThrowingDeleteUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.list(..))")
	public void logBeforeListUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.list(..))")
	public void logAfterListUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.list(..))", returning = "result")
	public void logAfterReturningListUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.list(..))", throwing = "error")
	public void logAfterThrowingListUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.validate(..))")
	public void logBeforeValidateUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.validate(..))")
	public void logAfterValidateUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.validate(..))", returning = "result")
	public void logAfterReturningValidateUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.validate(..))", throwing = "error")
	public void logAfterThrowingValidateUser(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.UserServiceImpl.exists(..))")
	public void logBeforeExistsUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserServiceImpl.exists(..))")
	public void logAfterExistsUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.exists(..))", returning = "result")
	public void logAfterReturningExistsUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserServiceImpl.exists(..))", throwing = "error")
	public void logAfterThrowingExistsUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
}