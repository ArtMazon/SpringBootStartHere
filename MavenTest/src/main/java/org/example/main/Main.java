package org.example.main;


import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        Parrot x = new Parrot();

        x.setName("Kiki");

        Supplier<Parrot> parrotProvider = () -> x;

        context.registerBean("Parrot1",Parrot.class,parrotProvider);

        System.out.println(context.getBean("Parrot1",Parrot.class).getName());




       /* String[] parrots = {"parrot1","parrot2","parrot3"};
        ArrayList<String> parrots2 = new ArrayList<>();

        for(String p : parrots){
            parrots2.add(p);
        }

        Arrays.stream(parrots).forEach((parrot)->{
            Parrot p = context.getBean(parrot,Parrot.class);
            System.out.println(p.getName());
        });

        parrots2.stream().forEach((parrot)->{
            Parrot p = context.getBean(parrot,Parrot.class);
            System.out.println(p.getName());
        });*/


       /* Parrot p = context.getBean(Parrot.class);

        System.out.println(p);
        System.out.println(p.getName());*/
    }
}