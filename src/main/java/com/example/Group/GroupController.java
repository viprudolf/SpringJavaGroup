package com.example.Group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// GroupController.java
@Controller
public class GroupController {


    @GetMapping("/group")
    public String group() {
        return "group";
    }
}



