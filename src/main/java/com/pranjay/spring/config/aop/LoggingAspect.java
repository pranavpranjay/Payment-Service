package com.pranjay.spring.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class LoggingAspect {

    @Before("execution(* *.*getAllPayments(..))")
    public void before(){
        log.info("Method is about to execute....");
    }

    @After("execution(* *.*getAllPayments(..))")
    public void after(){
        log.info("Method executed using AOP....");
    }

    @Around("execution(* *.*getAllPayments(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        log.info("Call method {} with Arg {}", methodName, methodArgs);
        Object result = joinPoint.proceed();
        log.info("Call method {} :  Result:  {}", methodName, result);
        return result;
    }

}