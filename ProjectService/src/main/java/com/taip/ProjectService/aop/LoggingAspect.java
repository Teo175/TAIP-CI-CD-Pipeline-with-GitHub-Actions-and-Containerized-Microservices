package com.taip.ProjectService.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.taip.ProjectService.business.ProjectService.*(..))")
    public void reportServiceMethods() {}

    @Before("reportServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
    }

    @After("reportServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
    }
}
