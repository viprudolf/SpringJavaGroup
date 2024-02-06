package com.example.Group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// StudentController.java
@Controller
public class StudentController {

    @GetMapping("/student")
    public String student() {
        return "student";
    }
}
