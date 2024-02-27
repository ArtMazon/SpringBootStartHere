package org.springwiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springwiring.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(p);
        System.out.println("Person name is : "+ person.getName());

        System.out.println("Person's parrot name is : "+ person.getParrot());
        System.out.println("Hello world!");
    }
}