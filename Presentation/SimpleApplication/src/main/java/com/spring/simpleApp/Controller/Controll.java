package com.spring.simpleApp.Controller;

import com.spring.simpleApp.Domain.Role;
import com.spring.simpleApp.Domain.User;
import com.spring.simpleApp.Repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller()
public class Controll {

@Autowired
private UserRepository userRepository;
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Controll.class);


    @PostMapping("/registration")
    public @ResponseBody String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.put("message", "User exist");
            return "redirect:/reg";
        }
        user.setRole(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "login";
    }
        @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
