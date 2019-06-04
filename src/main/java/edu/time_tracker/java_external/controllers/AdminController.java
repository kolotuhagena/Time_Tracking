package edu.time_tracker.java_external.controllers;

import edu.time_tracker.java_external.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/administrate/users")
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/userList";
    }
}
