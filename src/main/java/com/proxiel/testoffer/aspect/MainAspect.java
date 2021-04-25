package com.proxiel.testoffer.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Spring AOP implementation
 * Log the input parameters, count exectution time and give the returned values from methods
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Aspect
@Component
public class MainAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * <p>Before Pointcut
     * Get method params and log them
     * </p>
     *
     * @param joinPoint
     */
    @Before("@annotation(com.proxiel.testoffer.LogExecutionTime)")
    public void logBeforeExecution(JoinPoint joinPoint) {

        List<Object> signatureArgs = Arrays.asList(joinPoint.getArgs());
        String json = gson.toJson(signatureArgs);

        logger.info("The method parameters are : " + gson.toJson(signatureArgs));
    }

    /**
     * <p>Arround Pointcut
     * Count methods execution time
     * </p>
     *
     * @param joinPoint
     * @return Method execution time
     * @throws Throwable
     */
    @Around("@annotation(com.proxiel.testoffer.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;

        logger.info("The method : " + joinPoint.getSignature().getName() + " got executed in " + executionTime + "ms");

        return proceed;
    }

    /**
     * <p>AfterReturning Pointcut
     * Get method return values and log them
     * </p>
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "@annotation(com.proxiel.testoffer.LogExecutionTime)", returning = "result")
    public void logAfterExcecution(JoinPoint joinPoint, Object result) {

        logger.info("The method returns : " + gson.toJson(result));
    }

}
