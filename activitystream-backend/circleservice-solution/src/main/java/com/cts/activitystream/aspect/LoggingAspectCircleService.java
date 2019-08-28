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
public class LoggingAspectCircleService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggingAspectCircleService.class);

	/*
	 * Write loggers for each of the methods of CircleServiceImpl, any
	 * particular method will have all the four aspectJ annotation (@Before,
	 * @After, @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.service.CircleServiceImpl.save(..))")
	public void logBeforeSave(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.CircleServiceImpl.save(..))")
	public void logAfterSave(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.save(..))", returning = "result")
	public void logAfterReturningSave(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.save(..))", throwing = "error")
	public void logAfterThrowingSave(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.CircleServiceImpl.getAllCircles(..))")
	public void logBeforeGetAllCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.CircleServiceImpl.getAllCircles(..))")
	public void logAfterGetAllCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.getAllCircles(..))", returning = "result")
	public void logAfterReturningGetAllCircles(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.getAllCircles(..))", throwing = "error")
	public void logAfterThrowingGetAllCircles(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.CircleServiceImpl.get(..))")
	public void logBeforeGet(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.CircleServiceImpl.get(..))")
	public void logAfterGet(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.get(..))", returning = "result")
	public void logAfterReturningGet(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.get(..))", throwing = "error")
	public void logAfterThrowingGet(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.CircleServiceImpl.delete(..))")
	public void logBeforeDelete(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.CircleServiceImpl.delete(..))")
	public void logAfterDelete(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.delete(..))", returning = "result")
	public void logAfterReturningDelete(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.CircleServiceImpl.delete(..))", throwing = "error")
	public void logAfterThrowingDelete(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

}