package org.example.fintrack.Service;

import org.example.fintrack.Domain.Portfolio;
import org.example.fintrack.Domain.User;
import org.example.fintrack.Repository.PortoflioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    @Autowired
    private PortoflioRepository portoflioRepository;

    @Override
    public List<Portfolio> userPortfolios(User user) {

        return portoflioRepository.findByUserId(user.getId());
    }

    @Override
    public float totalEarning(User user) {

        float total = 0.0f;
        List<Portfolio> portfolios = userPortfolios(user);

        for (Portfolio p: portfolios) {
            total += p.getProfit();
        }

        return total;
    }
}
