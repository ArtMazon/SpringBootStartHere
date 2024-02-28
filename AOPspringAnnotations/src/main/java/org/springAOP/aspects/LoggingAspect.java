package org.springAOP.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springAOP.models.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());



    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        /*String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Method name: "+methodName +
                " with parameters "+ Arrays.asList(arguments)+" will execute");
*/
        logger.info("Logger aspect executing ");

        joinPoint.proceed();

        logger.info("Logger aspect executed ");

        return "Log aspect succed";

    }
}
