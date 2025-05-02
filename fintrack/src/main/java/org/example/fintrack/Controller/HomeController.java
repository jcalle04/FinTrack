package org.example.fintrack.Controller;

import org.example.fintrack.Service.TrendingMarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;



import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final TrendingMarketDataService trendingMarketDataService;

    @Autowired
    public HomeController(TrendingMarketDataService trendingMarketDataService) {
        this.trendingMarketDataService = trendingMarketDataService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        model.addAttribute("username", username);
        List<Map<String, Object>> stocks = trendingMarketDataService.getAllUsStocks();
        List<Map<String, Object>> trendingCryptos = trendingMarketDataService.getTrendingCryptos();

        model.addAttribute("stocks", stocks.subList(0, 10));
        model.addAttribute("trendingCryptos", trendingCryptos.subList(0, 10));

        return "home";
    }
}
