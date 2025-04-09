package org.example.fintrack.Controller;

import org.example.fintrack.Service.MarketDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {

    private final MarketDataService marketDataService;

    public MarketController(MarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    @GetMapping("/stock")
    public String getStockQuote(@RequestParam String symbol) {
        return marketDataService.getStockQuote(symbol);
    }

    @GetMapping("/crypto")
    public String getCryptoQuote(@RequestParam String symbol) {
        return marketDataService.getCryptoQuote(symbol);
    }

}
