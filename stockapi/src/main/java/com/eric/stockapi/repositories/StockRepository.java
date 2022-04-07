package com.eric.stockapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eric.stockapi.models.Payment;

public interface StockRepository extends MongoRepository<Payment,Long>{

}
