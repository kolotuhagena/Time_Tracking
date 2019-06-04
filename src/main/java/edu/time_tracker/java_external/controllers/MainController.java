package edu.time_tracker.java_external.controllers;

import edu.time_tracker.java_external.domain.entity.User;
import edu.time_tracker.java_external.service.user_service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MainController {
    private RegistrationService registrationService;

    public MainController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/sign_up")
    public @ResponseBody
    String addUser(User user, Map<String, Object> model){
        registrationService.registration(user, model);
        return "/login";
    }
}
