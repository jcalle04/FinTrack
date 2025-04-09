package org.example.fintrack.Service;

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
    private final String FINNHUB_API_KEY = "your-finnhub-api-key";
    private final String BASE_URL = "https://finnhub.io/api/v1";

    @Autowired
    public TrendingMarketDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to fetch trending stocks
    public List<String> getTrendingStocks() {
        String url = BASE_URL + "/stock/trending?token=" + FINNHUB_API_KEY;
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, null, Map.class);

        Map<String, Object> responseBody = response.getBody();
        return (List<String>) responseBody.get("stocks");
    }

    // Method to fetch trending cryptos
    public List<String> getTrendingCryptos() {
        String url = BASE_URL + "/crypto/trending?token=" + FINNHUB_API_KEY;
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, null, Map.class);

        Map<String, Object> responseBody = response.getBody();
        return (List<String>) responseBody.get("cryptos");  // Assuming 'cryptos' is the key that holds the list of trending cryptos
    }

}
