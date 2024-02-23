package com.example.Group.Models.Design;
import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Models.Group;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("/orderForm")
@SessionAttributes("tacoOrder")
public class OrderController {
    private GroupRepository groupRepository;
    public OrderController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    @GetMapping
    public String orderForm() {
        return "orderForm";
    }
    @PostMapping
    public String processOrder(Group group, SessionStatus sessionStatus) {

        groupRepository.save(group);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}