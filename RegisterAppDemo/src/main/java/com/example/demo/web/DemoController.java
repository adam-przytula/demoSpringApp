package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String root ( ModelMap map ){

        map.put("hello", "mam na imie adam");


        return "register";
    }

//    @PostMapping("/")
//    public String rootPost(User user){
//        userRepo.save(user);
//
//        return "redirect:/register";
//
//    }

}
