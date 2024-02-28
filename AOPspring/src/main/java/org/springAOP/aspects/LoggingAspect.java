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



    @Around("execution(* org.springAOP.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Method name: "+methodName +
                " with parameters "+ Arrays.asList(arguments)+" will execute");

        Comment comment = new Comment();
        comment.setAuthor("Ashkenazi");
        comment.setText("Hello World");

        Object[] newArguments = {comment};
        Object returnedByMethod = joinPoint.proceed(newArguments);

        logger.info("Method executed and returned: "+returnedByMethod);

        return "FAILED";

    }
}
