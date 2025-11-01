package com.example.aop;

import java.util.logging.Logger;

/**
 * AOP aspect for argument validation
 */
public class ValidationAspect {
    private static final Logger logger = Logger.getLogger(ValidationAspect.class.getName());

    public void validateArguments(String methodName, Object[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        for (Object arg : args) {
            if (arg == null) {
                logger.warning("[VALIDATION] " + methodName + " - Null argument detected");
            }
            if (arg instanceof String && ((String) arg).trim().isEmpty()) {
                logger.warning("[VALIDATION] " + methodName + " - Empty string argument detected");
            }
        }
    }
}