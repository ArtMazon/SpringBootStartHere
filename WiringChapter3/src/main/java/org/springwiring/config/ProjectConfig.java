package org.springwiring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springwiring.Parrot;
import org.springwiring.Person;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    public Person person(Parrot parrot){
        Person person = new Person();
        person.setName("Anastasia");
        person.setParrot(parrot);
        return person;

    }







}
