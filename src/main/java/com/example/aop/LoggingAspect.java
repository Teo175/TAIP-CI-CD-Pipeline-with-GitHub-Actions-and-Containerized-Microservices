package com.example.aop;

// AOP Pattern: Cross-cutting concern for logging
public class LoggingAspect {

    public void logBefore(String methodName) {
        System.out.println("[AOP] Before executing: " + methodName);
    }

    public void logAfter(String methodName) {
        System.out.println("[AOP] After executing: " + methodName);
    }
}