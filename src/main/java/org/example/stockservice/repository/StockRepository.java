package org.example.stockservice.repository;

import org.example.stockservice.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
