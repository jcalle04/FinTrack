package org.example.fintrack.Service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Service
public class TrendingMarketDataService {

    private final RestTemplate restTemplate;
    private final String FINNHUB_API_KEY = "cvre3mhr01qp88cpqlggcvre3mhr01qp88cpqlh0";
    private final String BASE_URL = "https://finnhub.io/api/v1";

    @Autowired
    public TrendingMarketDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to fetch trending stocks
    public List<Map<String, Object>> getAllUsStocks() {
        String url = BASE_URL + "/stock/symbol?exchange=US&token=" + FINNHUB_API_KEY;
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public List<Map<String, Object>> getTrendingCryptos() {
        String url = BASE_URL + "/crypto/symbol?exchange=BINANCE&token=" + FINNHUB_API_KEY;
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

}
