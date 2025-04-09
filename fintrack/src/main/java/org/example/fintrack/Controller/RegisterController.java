package org.example.fintrack.Controller;

import org.example.fintrack.Domain.LoginForm;
import org.example.fintrack.Domain.RegisterForm;
import org.example.fintrack.Repository.UserRepository;
import org.example.fintrack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerForm") RegisterForm form, Model model) {

        if(userService.authenticateRegister(form.getEmail(), form.getPassword(), form.getRepeatPassword())) {
            userService.createUser(form.getEmail(), form.getPassword());
            return "index";
        }

        return "register";
    }
}
