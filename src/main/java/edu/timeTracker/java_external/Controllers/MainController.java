package edu.timeTracker.java_external.Controllers;

import edu.timeTracker.java_external.domain.entity.User;
import edu.timeTracker.java_external.service.UserService.RegistrationService;
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
