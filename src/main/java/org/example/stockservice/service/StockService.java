package org.example.stockservice.service;

import org.example.stockservice.domain.Stock;
import org.example.stockservice.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional
    // synchronized 메소드는 하나의 프로세스에서만 실행되도록 보장한다.
    // 대부분의 서비스는 여러 서버에서 돌아가기 때문에 synchronized를 사용하기 힘들다.
    public synchronized void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

    }

}
