package com.springpractice.exercisechapter10.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public  String hello(@RequestParam(required = false) String name){

        if (name == null){
            return "Hello";
        }

        return "Hello! " + name;
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao!";
    }


}
