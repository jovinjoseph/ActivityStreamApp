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
public class LoggingAspectMessageService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggingAspectMessageService.class);

	/*
	 * Write loggers for each of the methods of MessageServiceImpl, any
	 * particular method will have all the four aspectJ annotation (@Before,
	 * @After, @AfterReturning, @AfterThrowing).
	 */
	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromCircle(..))")
	public void logBeforeGetMessagesFromCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromCircle(..))")
	public void logAfterGetMessagesFromCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromCircle(..))", returning = "result")
	public void logAfterReturningGetMessagesFromCircle(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromCircle(..))", throwing = "error")
	public void logAfterThrowingGetMessagesFromCircle(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromUser(..))")
	public void logBeforeGetMessagesFromUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromUser(..))")
	public void logAfterGetMessagesFromUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromUser(..))", returning = "result")
	public void logAfterReturningGetMessagesFromUser(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.getMessagesFromUser(..))", throwing = "error")
	public void logAfterThrowingGetMessagesFromUser(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToCircle(..))")
	public void logBeforeSendMessageToCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToCircle(..))")
	public void logAfterSendMessageToCircle(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToCircle(..))", returning = "result")
	public void logAfterReturningSendMessageToCircle(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToCircle(..))", throwing = "error")
	public void logAfterThrowingSendMessageToCircle(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToUser(..))")
	public void logBeforeSendMessageToUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToUser(..))")
	public void logAfterSendMessageToUser(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToUser(..))", returning = "result")
	public void logAfterReturningSendMessageToUser(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.sendMessageToUser(..))", throwing = "error")
	public void logAfterThrowingSendMessageToUser(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.listTags(..))")
	public void logBeforeListTags(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.listTags(..))")
	public void logAfterListTags(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.listTags(..))", returning = "result")
	public void logAfterReturningListTags(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.listTags(..))", throwing = "error")
	public void logAfterThrowingListTags(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.listMyTags(..))")
	public void logBeforeListMyTags(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.listMyTags(..))")
	public void logAfterListMyTags(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.listMyTags(..))", returning = "result")
	public void logAfterReturningListMyTags(JoinPoint joinPoint, Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.listMyTags(..))", throwing = "error")
	public void logAfterThrowingListMyTags(JoinPoint joinPoint, Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}

	@Before("execution(* com.cts.activitystream.service.MessageServiceImpl.showMessagesWithTag(..))")
	public void logBeforeShowMessagesWithTag(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cts.activitystream.service.MessageServiceImpl.showMessagesWithTag(..))")
	public void logAfterShowMessagesWithTag(JoinPoint joinPoint) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.showMessagesWithTag(..))", returning = "result")
	public void logAfterReturningShowMessagesWithTag(JoinPoint joinPoint,
			Object result) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.cts.activitystream.service.MessageServiceImpl.showMessagesWithTag(..))", throwing = "error")
	public void logAfterThrowingShowMessagesWithTag(JoinPoint joinPoint,
			Throwable error) {
		LOGGER.debug("Method Name : " + joinPoint.getSignature().getName());
		LOGGER.debug("Method arguments : "
				+ Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("Exception : " + error);
	}
}