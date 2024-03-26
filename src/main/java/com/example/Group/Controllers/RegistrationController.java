package com.example.Group.Controllers;

import com.example.Group.Forms.RegistrationForm;
import com.example.Group.Models.UserModel;
import com.example.Group.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "Registration";
    }

    @PostMapping
    public String proccessRegistration(RegistrationForm form){
        UserModel user = form.toUser(passwordEncoder);
        user.setId(System.currentTimeMillis());
        userRepo.save(user);
        return "redirect:/login";
    }
}