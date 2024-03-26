package com.example.Group.Controllers;

import com.example.Group.Models.Faculties;
import com.example.Group.Repositories.FacultiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/faculty")
@SessionAttributes("list")
@Controller
public class FacultyController {
    private final FacultiesRepository facultiesRepository;

    @Autowired
    public FacultyController(FacultiesRepository facultiesRepository) {this.facultiesRepository = facultiesRepository;}

    @GetMapping
    public String show(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("authname", userDetails.getUsername()+": Выход");
        Faculties faculty = new Faculties();
        model.addAttribute("faculty",faculty);
        Iterable<Faculties> faculties = facultiesRepository.findAll();
        model.addAttribute("list", faculties);
        return "Faculty";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("faculty") Faculties faculty, BindingResult result) {
        if(result.hasErrors()){
            return "Faculty";
        }
        else{
            facultiesRepository.saveFaculty(faculty);return "redirect:/faculty";}
    }

    @PostMapping(value = "/remove")
    public String remove(@ModelAttribute(value = "var") Faculties faculty) {
        facultiesRepository.deleteFaculty(faculty.getId());
        return "redirect:/faculty";
    }

    @PostMapping(value = "/refactor_first")
    public String update_start(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute(value = "var") Faculties faculty, Model model) {
        model.addAttribute("authname", userDetails.getUsername()+": Выход");
        model.addAttribute("faculty",faculty);
        Iterable<Faculties> faculties = facultiesRepository.findAll();
        model.addAttribute("list", faculties);
        return "RefFaculty";
    }

    @PostMapping(value = "/refactor_second")
    public String update_end(@ModelAttribute(value = "faculty") Faculties faculty) {
        facultiesRepository.updateFaculty(faculty);
        return "redirect:/faculty";
    }
}