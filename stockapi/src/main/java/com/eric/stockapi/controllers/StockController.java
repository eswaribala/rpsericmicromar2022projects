package com.eric.stockapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.stockapi.models.Payment;
import com.eric.stockapi.services.StockConsumerService;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
	private StockConsumerService stockService;
    @GetMapping({"/v1.0"})
    public Payment getPayment() {
    	return this.stockService.getPaymentDetails();
    }
}
