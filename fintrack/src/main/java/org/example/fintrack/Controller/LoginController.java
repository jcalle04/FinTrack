package org.example.fintrack.Controller;

import org.example.fintrack.Domain.LoginForm;
import org.example.fintrack.Domain.User;
import org.example.fintrack.Repository.UserRepository;
import org.example.fintrack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form, Model model) {

        if (userService.authenticate(form.getEmail(), form.getPassword())) {
            return "home";
        }

        return "register";
    }
}
