package com.example.Group.Controllers;

import com.example.Group.Models.Chairs;
import com.example.Group.Models.Faculties;
import com.example.Group.Repositories.ChairsRepository;
import com.example.Group.Repositories.FacultiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/chair")
@SessionAttributes("list")
@Controller
public class ChairController {
    private final ChairsRepository chairsRepository;
    private final FacultiesRepository facultiesRepository;
    @Autowired
    public ChairController(ChairsRepository chairsRepository, FacultiesRepository facultiesRepo){
        this.chairsRepository = chairsRepository;
        this.facultiesRepository = facultiesRepo;
    }
    @GetMapping
    public String read(@AuthenticationPrincipal UserDetails userDetails, Model model){
        model.addAttribute("authname", userDetails.getUsername()+": Выход");
        Chairs chair = new Chairs();
        model.addAttribute("chair", chair);
        Iterable<Chairs> chairs = chairsRepository.findAll();
        Iterable<Faculties> faculties = facultiesRepository.findAll();
        model.addAttribute("faculties", faculties);
        model.addAttribute("list", chairs);
        return "Chair";
    }
    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute(value = "chair") Chairs chair, BindingResult result, Model model) {
        chair.setFaculties(facultiesRepository.findById(chair.getFaculty_id()).get());
        if (result.hasErrors()){
            model.addAttribute("faculties", facultiesRepository.findAll());
            return "Chair";}
        else{
            chairsRepository.saveChair(chair);
            return "redirect:/chair";}
    }
    @PostMapping(value = "/remove")
    public String remove(@ModelAttribute(value = "var") Chairs chair) {
        chairsRepository.deleteChair(chair.getId());
        return "redirect:/chair";
    }
    @PostMapping(value = "/refactor_first")
    public String refactor_first(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute(value = "var") Chairs chair, Model model) {
        model.addAttribute("authname", userDetails.getUsername()+": Выход");
        chair.setFaculties(facultiesRepository.findById(chair.getFaculty_id()).get());
        model.addAttribute("chair", chair);
        Iterable<Chairs> chairs = chairsRepository.findAll();
        model.addAttribute("list", chairs);
        Iterable<Faculties> faculties = facultiesRepository.findAll();
        model.addAttribute("faculties", faculties);
        return "RefChair";
    }
    @PostMapping(value = "/refactor_second")
    public String refactor_second(@ModelAttribute(value = "chair") Chairs chair) {
        chair.setFaculties(facultiesRepository.findById(chair.getFaculty_id()).get());
        chairsRepository.updateChair(chair);
        return "redirect:/chair";
    }
}