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
public class LoggingAspectMessage {
	private static final Logger logger = LoggerFactory
			.getLogger(LoggingAspectMessage.class);

	/*
	 * Write loggers for each of the methods of REST controller, any particular
	 * method will have all the four aspectJ annotation (@Before, @After,
	 * @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.controller.MessageController.sendMessageToCircle(..))")
	public void logBeforeSendMessageToCircle(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.sendMessageToCircle(..))")
	public void logAfterSendMessageToCircle(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.sendMessageToCircle(..))", returning = "result")
	public void logAfterReturningSendMessageToCircle(JoinPoint joinPoint,
			Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.sendMessageToCircle(..))", throwing = "error")
	public void logAfterThrowingSendMessageToCircle(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for sendMessageToUser method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.sendMessageToUser(..))")
	public void logBeforeSendMessageToUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.sendMessageToUser(..))")
	public void logAfterSendMessageToUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.sendMessageToUser(..))", returning = "result")
	public void logAfterReturningSendMessageToUser(JoinPoint joinPoint,
			Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.sendMessageToUser(..))", throwing = "error")
	public void logAfterThrowingSendMessageToUser(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for getUser method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.getMessagesByUser(..))")
	public void logBeforeGetMessagesByUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.getMessagesByUser(..))")
	public void logAfterListGetMessagesByUser(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.getMessagesByUser(..))", returning = "result")
	public void logAfterReturningGetMessagesByUser(JoinPoint joinPoint,
			Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.getMessagesByUser(..))", throwing = "error")
	public void logAfterThrowingGetMessagesByUser(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for getMessagesByCircle method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.getMessagesByCircle(..))")
	public void logBeforeGetMessagesByCircle(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.getMessagesByCircle(..))")
	public void logAfterListGetMessagesByCircle(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.getMessagesByCircle(..))", returning = "result")
	public void logAfterReturningGetMessagesByCircle(JoinPoint joinPoint,
			Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.getMessagesByCircle(..))", throwing = "error")
	public void logAfterThrowingGetMessagesByCircle(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for listAllTags method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.listAllTags(..))")
	public void logBeforeListAllTags(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.listAllTags(..))")
	public void logAfterListAllTags(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.listAllTags(..))", returning = "result")
	public void logAfterReturningListAllTags(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.listAllTags(..))", throwing = "error")
	public void logAfterThrowingListAllTags(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for getUser method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.showMessagesWithTag(..))")
	public void logBeforeShowMessagesWithTag(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.showMessagesWithTag(..))")
	public void logAfterShowMessagesWithTag(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.showMessagesWithTag(..))", returning = "result")
	public void logAfterReturningShowMessagesWithTag(JoinPoint joinPoint,
			Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.showMessagesWithTag(..))", throwing = "error")
	public void logAfterThrowingShowMessagesWithTag(JoinPoint joinPoint,
			Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for subscribe method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.subscribe(..))")
	public void logBeforeSubscribe(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.subscribe(..))")
	public void logAfterSubscribe(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.subscribe(..))", returning = "result")
	public void logAfterReturningSubscribe(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.subscribe(..))", throwing = "error")
	public void logAfterThrowingSubscribe(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for unSubscribe method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.unSubscribe(..))")
	public void logBeforeUnSubscribe(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.unSubscribe(..))")
	public void logAfterListUnSubscribe(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.unSubscribe(..))", returning = "result")
	public void logAfterReturningUnSubscribe(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.unSubscribe(..))", throwing = "error")
	public void logAfterThrowingUnSubscribe(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}

	/* AOP methods for searchTags method - MessageController */
	@Before("execution(* com.cts.activitystream.controller.MessageController.searchTags(..))")
	public void logBeforeSearchTags(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.controller.MessageController.searchTags(..))")
	public void logAfterListSearchTags(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.controller.MessageController.searchTags(..))", returning = "result")
	public void logAfterReturningSearchTags(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.controller.MessageController.searchTags(..))", throwing = "error")
	public void logAfterThrowingSearchTags(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}
}