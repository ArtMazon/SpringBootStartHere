package com.springpractice.chapter11excercise1.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.springpractice.chapter11excercise1.proxies")
public class ProjectConfig {
}
