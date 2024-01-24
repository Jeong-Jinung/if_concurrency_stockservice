package org.example.stockservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.example.stockservice.domain.Stock;
import org.example.stockservice.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before() {
        stockRepository.saveAndFlush(new Stock(1L, 100L));
    }

    @AfterEach
    public void after() {
        stockRepository.deleteAll();
    }

    @Test
    @DisplayName("재고감소")
    void decrease() {
        stockService.decrease(1L, 1L);
        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertEquals(99L, stock.getQuantity());

    }

}