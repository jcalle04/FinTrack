package org.example.fintrack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String LoginForm(Model model) {
        model.addAttribute("PageTitle", "Home");
        return "index";
    }

}
