package org.springwiring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springwiring.config.ConfigClass;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ConfigClass.class);


        Person p = context.getBean(Person.class);

        System.out.println(p.getName());
        System.out.println(p.getParrot());

        System.out.println("Hello world!");
    }
}