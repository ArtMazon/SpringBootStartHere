package com.chapter7.exercisechapter7;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/home")
    public String homePage(){
        return "home.html";
    }
}