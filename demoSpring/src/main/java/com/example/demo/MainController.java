package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.User;
import com.example.demo.UserRepository;

@Controller    // adnotacja oznaczająca kontroler
@RequestMapping(path="/demo") // maping ustawiający początek URL kontrolera na /demo
public class MainController {

    @Autowired // userRepository jest interfejsem, nie napisaliśmy do niego implementacji
    // Autowired jest wskazówką dla Springa aby utworzył implementacje
    private UserRepository userRepository;

    @GetMapping(path="/add") // Mapowanie tylko dla metody GET HTTP
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody oznacza, że odpowiedzią HTTP będzie String "Saved", a nie nazwa widoku
        // @RequestParam oznacza, że to parametr z requestu GET lub POST

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}