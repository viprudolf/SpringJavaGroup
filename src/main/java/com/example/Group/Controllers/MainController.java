package com.example.Group.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String fun(@AuthenticationPrincipal UserDetails userDetails, Model model){
        model.addAttribute("authname", "Войти");
        if(userDetails!=null){
            model.addAttribute("authname", userDetails.getUsername()+": Выход");
        }
        return "Main";
    }
}