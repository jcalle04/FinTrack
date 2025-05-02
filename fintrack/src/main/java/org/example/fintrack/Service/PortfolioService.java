package org.example.fintrack.Service;

import org.example.fintrack.Domain.Portfolio;
import org.example.fintrack.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PortfolioService {

    public List<Portfolio> userPortfolios(User user);

    public float totalEarning(User user);
}
