package org.example.fintrack.Controller;

import org.example.fintrack.Service.TrendingMarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final TrendingMarketDataService trendingMarketDataService;

    @Autowired
    public HomeController(TrendingMarketDataService trendingMarketDataService) {
        this.trendingMarketDataService = trendingMarketDataService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<String> trendingStocks = trendingMarketDataService.getTrendingStocks();
        List<String> trendingCryptos = trendingMarketDataService.getTrendingCryptos();

        model.addAttribute("trendingStocks", trendingStocks);
        model.addAttribute("trendingCryptos", trendingCryptos);

        return "home";  // This is the view name for the home page
    }
}
