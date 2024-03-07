package com.springpractice.exercisechapter9.controllers;


import com.springpractice.exercisechapter9.services.LoggedUserManagementService;
import com.sun.tools.javac.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    public MainController(LoggedUserManagementService loggedUserManagementService){

        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String getMain(@RequestParam(required = false) String logout,
                          Model model){

        if(logout!= null){
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();


        if (username == null){
            return "redirect:/";
        }

        model.addAttribute("username",username);
        return "main.html";
    }


}
