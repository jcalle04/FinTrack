package org.example.fintrack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketDataService {

    @Value("${finnhub.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public MarketDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStockQuote(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, apiKey);
        return restTemplate.getForObject(url, String.class);
    }

    public String getCryptoQuote(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, apiKey);
        return restTemplate.getForObject(url, String.class);
    }


}
