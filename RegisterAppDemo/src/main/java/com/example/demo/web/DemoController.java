package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String root(ModelMap model){
        List<User> allUsers = userRepo.findAll();

        User user = new User();

        model.put("allUsers", allUsers);
        model.put("user", user);
        return "register";
    }

    @PostMapping
    public String rootPost(User user){
        userRepo.save(user);

        return "redirect:/";

    }

}
