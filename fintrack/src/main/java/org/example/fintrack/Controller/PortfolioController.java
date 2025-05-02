package org.example.fintrack.Controller;

import org.example.fintrack.Domain.Portfolio;
import org.example.fintrack.Domain.User;
import org.example.fintrack.Service.PortfolioService;
import org.example.fintrack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @GetMapping("/portfolios")
    public String portfoliosPage(Model model, Principal principal) {

        User u = userService.findByUsername(principal.getName());
        List<Portfolio> portfolioList = portfolioService.userPortfolios(u);

        float totalEarning = portfolioService.totalEarning(u);

        model.addAttribute("Username", u.getUsername());
        model.addAttribute("PortfolioList", portfolioList);
        model.addAttribute("Total", totalEarning);

        return "portfolios";


    }
}
