package com.taip.reportservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.taip.reportservice.business.ReportService.*(..))")
    public void reportServiceMethods() {}

    @Before("reportServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
    }

    @After("reportServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Completed method: " + joinPoint.getSignature().getName());
    }
}

