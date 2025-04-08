package org.example.fintrack.Controller;

import org.example.fintrack.Domain.LoginForm;
import org.example.fintrack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String Register(Model model) {
        //model.addAttribute("Email" );
        return "register";
    }
}
