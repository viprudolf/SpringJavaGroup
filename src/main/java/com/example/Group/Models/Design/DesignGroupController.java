package com.example.Group.Models.Design;

import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Models.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignGroupController {
    private final GroupRepository groupRepository;
    @Autowired
    public DesignGroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    @ModelAttribute
    public void addGroupToModel(Model model) {

    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute(name = "tacoOrder")
    public Group order() {
        return new Group(1);
    }

    @PostMapping
    public String processTaco(@ModelAttribute Group group) {
        return "redirect:/design";
    }
    private Iterable<Group> filterByType(Iterable<Group> groups) {
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }
}
