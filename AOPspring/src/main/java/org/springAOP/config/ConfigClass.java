package org.springAOP.config;

import org.springAOP.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.springAOP.services")
public class ConfigClass {

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
