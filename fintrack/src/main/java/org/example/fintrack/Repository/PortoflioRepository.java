package org.example.fintrack.Repository;

import org.example.fintrack.Domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortoflioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByUserId(Long id);
}
