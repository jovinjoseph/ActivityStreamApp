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
public class LoggingAspectUserCircleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectUserCircleService.class);
	/*Write loggers for each of the methods of UserCircleServiceImpl, 
    any particular method will have all the four aspectJ annotation
    (@Before, @After, @AfterReturning, @AfterThrowing).
    */
	@Before("execution(* com.cts.activitystream.service.UserCircleServiceImpl.addUser(..))")
	public void logBeforeAddUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserCircleServiceImpl.addUser(..))")
	public void logAfterAddUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.addUser(..))", returning = "result")
	public void logAfterReturningAddUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.addUser(..))", throwing = "error")
	public void logAfterThrowingAddUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
	@Before("execution(* com.cts.activitystream.service.UserCircleServiceImpl.removeUser(..))")
	public void logBeforeRemoveUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserCircleServiceImpl.removeUser(..))")
	public void logAfterRemoveUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.removeUser(..))", returning = "result")
	public void logAfterReturningRemoveUser(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.removeUser(..))", throwing = "error")
	public void logAfterThrowingRemoveUser(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
	@Before("execution(* com.cts.activitystream.service.UserCircleServiceImpl.getMyCircles(..))")
	public void logBeforeGetMyCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserCircleServiceImpl.getMyCircles(..))")
	public void logAfterGetMyCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.getMyCircles(..))", returning = "result")
	public void logAfterReturningGetMyCircles(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.getMyCircles(..))", throwing = "error")
	public void logAfterThrowingGetMyCircles(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
	@Before("execution(* com.cts.activitystream.service.UserCircleServiceImpl.get(..))")
	public void logBeforeGetCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.UserCircleServiceImpl.get(..))")
	public void logAfterGetCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.get(..))", returning = "result")
	public void logAfterReturningGetCircle(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.UserCircleServiceImpl.get(..))", throwing = "error")
	public void logAfterThrowingGetCircle(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
}