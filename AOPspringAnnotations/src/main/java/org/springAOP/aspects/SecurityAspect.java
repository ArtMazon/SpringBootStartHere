package org.springAOP.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect

public class SecurityAspect {


    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());
    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect executing");

        joinPoint.proceed();

        logger.info("Security aspect executed");





        return "security aspect succeded";


    }
}
