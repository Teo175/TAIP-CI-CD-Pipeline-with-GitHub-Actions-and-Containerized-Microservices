package com.example.aop;

import java.lang.reflect.*;

/**
 * Enhanced AOP proxy supporting multiple aspects and proper exception handling
 */
public class AOPProxy {

    /**
     * Creates a proxy with logging aspect
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, LoggingAspect aspect) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            aspect.logBefore(method.getName(), args);
                            Object result = method.invoke(target, args);
                            aspect.logAfter(method.getName(), result);
                            return result;
                        } catch (InvocationTargetException e) {
                            // Unwrap the actual exception
                            Throwable actualException = e.getTargetException();
                            aspect.logException(method.getName(), actualException);
                            throw actualException;
                        } catch (Exception e) {
                            aspect.logException(method.getName(), e);
                            throw e;
                        }
                    }
                }
        );
    }

    /**
     * Creates a proxy with performance monitoring
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxyWithPerformance(T target, PerformanceAspect aspect) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    try {
                        aspect.startTiming(method.getName());
                        Object result = method.invoke(target, args);
                        return result;
                    } finally {
                        aspect.endTiming(method.getName());
                    }
                }
        );
    }

    /**
     * Creates a proxy with multiple aspects (logging + performance + validation)
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxyWithMultipleAspects(
            T target,
            LoggingAspect loggingAspect,
            PerformanceAspect performanceAspect,
            ValidationAspect validationAspect) {

        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            // Before execution: validation, logging, performance start
                            if (validationAspect != null) {
                                validationAspect.validateArguments(method.getName(), args);
                            }

                            if (loggingAspect != null) {
                                loggingAspect.logBefore(method.getName(), args);
                            }

                            if (performanceAspect != null) {
                                performanceAspect.startTiming(method.getName());
                            }

                            // Execute actual method
                            Object result = method.invoke(target, args);

                            // After successful execution: logging
                            if (loggingAspect != null) {
                                loggingAspect.logAfter(method.getName(), result);
                            }

                            return result;

                        } catch (InvocationTargetException e) {
                            Throwable actualException = e.getTargetException();
                            if (loggingAspect != null) {
                                loggingAspect.logException(method.getName(), actualException);
                            }
                            throw actualException;
                        } catch (Exception e) {
                            if (loggingAspect != null) {
                                loggingAspect.logException(method.getName(), e);
                            }
                            throw e;
                        } finally {
                            // Always log performance
                            if (performanceAspect != null) {
                                performanceAspect.endTiming(method.getName());
                            }
                        }
                    }
                }
        );
    }

    /**
     * Builder pattern for creating proxies with custom aspect configuration
     */
    public static class ProxyBuilder<T> {
        private final T target;
        private LoggingAspect loggingAspect;
        private PerformanceAspect performanceAspect;
        private ValidationAspect validationAspect;

        public ProxyBuilder(T target) {
            this.target = target;
        }

        public ProxyBuilder<T> withLogging() {
            this.loggingAspect = new LoggingAspect();
            return this;
        }

        public ProxyBuilder<T> withPerformance() {
            this.performanceAspect = new PerformanceAspect();
            return this;
        }

        public ProxyBuilder<T> withValidation() {
            this.validationAspect = new ValidationAspect();
            return this;
        }

        public T build() {
            if (loggingAspect == null && performanceAspect == null && validationAspect == null) {
                return target; // No aspects, return original
            }

            return createProxyWithMultipleAspects(target, loggingAspect, performanceAspect, validationAspect);
        }
    }

    /**
     * Convenient builder factory method
     */
    public static <T> ProxyBuilder<T> builder(T target) {
        return new ProxyBuilder<>(target);
    }
}