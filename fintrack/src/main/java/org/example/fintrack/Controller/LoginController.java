package org.example.fintrack.Controller;

import org.example.fintrack.Domain.LoginForm;
import org.example.fintrack.Domain.User;
import org.example.fintrack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form, Model model) {
        User user = userRepository.findByEmail(form.getEmail());

        if (user != null && user.getPassword().equals(form.getPassword())) {
            return "redirect:/home";
        }

        model.addAttribute("error", "Invalid email or password");
        return "index";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}
