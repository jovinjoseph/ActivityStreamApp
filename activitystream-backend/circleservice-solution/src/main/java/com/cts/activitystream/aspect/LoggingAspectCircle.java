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
public class LoggingAspectCircle {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggingAspectCircle.class);

	/*
	 * Write loggers for each of the methods of REST controller, any particular
	 * method will have all the four aspectJ annotation (@Before, @After,
	 * @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.controller.CircleController.createCircle(..))")
	public void logBeforeCreateCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.CircleController.createCircle(..))")
	public void logAfterCreateCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.CircleController.createCircle(..))", returning = "result")
	public void logAfterReturningCreateCircle(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.CircleController.createCircle(..))", throwing = "error")
	public void logAfterThrowingCreateCircle(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	/* AOP methods for retrieveCircles method - CircleController */
	@Before("execution(* com.cts.activitystream.controller.CircleController.retrieveCircles(..))")
	public void logBeforeRetrieveCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.CircleController.retrieveCircles(..))")
	public void logAfterListRetrieveCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.CircleController.retrieveCircles(..))", returning = "result")
	public void logAfterReturningRetrieveCircles(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.CircleController.retrieveCircles(..))", throwing = "error")
	public void logAfterThrowingRetrieveCircles(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	/* AOP methods for searchCircles method - CircleController */
	@Before("execution(* com.cts.activitystream.controller.CircleController.searchCircles(..))")
	public void logBeforeSearchCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.CircleController.searchCircles(..))")
	public void logAfterListSearchCircles(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.CircleController.searchCircles(..))", returning = "result")
	public void logAfterReturningSearchCircles(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.CircleController.searchCircles(..))", throwing = "error")
	public void logAfterThrowingSearchCircles(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
}