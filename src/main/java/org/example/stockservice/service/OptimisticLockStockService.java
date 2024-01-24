package org.example.stockservice.service;

import org.example.stockservice.domain.Stock;
import org.example.stockservice.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptimisticLockStockService {

    private final StockRepository stockRepository;

    public OptimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithOptimisticLock(id);

        stock.decrease(quantity);

        stockRepository.save(stock);
    }

}
