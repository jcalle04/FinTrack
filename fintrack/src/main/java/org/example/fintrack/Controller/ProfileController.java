package org.example.fintrack.Controller;

import org.example.fintrack.Domain.User;
import org.example.fintrack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal) {

        String username = principal.getName();
        model.addAttribute("Username", username);

        User u = userService.findByUsername(username);

        if (u != null) {
            model.addAttribute("Email", u.getEmail());
            model.addAttribute("Name", u.getName());
            model.addAttribute("Surname", u.getSurname());
            model.addAttribute("Password", u.getPassword());
        } else {
            return "redirect:/login?error";
        }

        return "profile";
    }

}
