package com.example.aop;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Enhanced AOP aspect for logging with proper exception handling
 */
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * Log before method execution
     */
    public void logBefore(String methodName, Object[] args) {
        String argsString = args != null && args.length > 0
                ? Arrays.toString(args)
                : "no args";
        logger.info("[AOP-BEFORE] " + methodName + " - Args: " + argsString);
    }

    /**
     * Log after successful method execution
     */
    public void logAfter(String methodName, Object result) {
        logger.info("[AOP-AFTER] " + methodName + " - Result: " +
                (result != null ? result.getClass().getSimpleName() : "void"));
    }

    /**
     * Log when method throws exception
     */
    public void logException(String methodName, Throwable throwable) {
        logger.severe("[AOP-EXCEPTION] " + methodName + " - Error: " +
                throwable.getClass().getSimpleName() + " - " + throwable.getMessage());
    }
}