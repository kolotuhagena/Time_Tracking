package edu.TimeTracker.Java_external.Controllers;

import edu.TimeTracker.Java_external.domain.entity.User;
import edu.TimeTracker.Java_external.service.UserService.UserService;
import edu.TimeTracker.Java_external.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private ValidationService validationService;

    @Autowired
    private UserService userService;

    @PostMapping("/sign_up")
    public @ResponseBody
    String addUser(User user, Map<String, Object> model){
        Optional<User> userFromDb = userService.getUserFromDB(user.getUsername());
        if(userFromDb.isPresent()){
            model.put("message", "User exist");
            return "redirect:/reg";
        }
        user.setRole(User.Role.USER);
        userService.add(user);
        return "login";
    }
}
