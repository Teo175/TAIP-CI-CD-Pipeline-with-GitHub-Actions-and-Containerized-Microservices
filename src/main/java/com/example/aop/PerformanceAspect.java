package com.example.aop;

import java.util.logging.Logger;

/**
 * AOP aspect for performance monitoring
 */
public class PerformanceAspect {
    private static final Logger logger = Logger.getLogger(PerformanceAspect.class.getName());
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    public void startTiming(String methodName) {
        startTime.set(System.currentTimeMillis());
        logger.fine("[PERF] Starting: " + methodName);
    }

    public void endTiming(String methodName) {
        Long start = startTime.get();
        if (start != null) {
            long duration = System.currentTimeMillis() - start;
            logger.info("[PERF] " + methodName + " took " + duration + "ms");
            startTime.remove();
        }
    }
}