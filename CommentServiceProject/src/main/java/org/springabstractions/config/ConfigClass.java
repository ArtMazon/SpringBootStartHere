package org.springabstractions.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.springabstractions.proxies",
        "org.springabstractions.repositories","org.springabstractions.services"})
public class ConfigClass {
}
