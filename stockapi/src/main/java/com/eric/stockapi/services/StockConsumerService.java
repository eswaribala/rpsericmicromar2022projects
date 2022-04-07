package com.eric.stockapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.eric.stockapi.channels.StockChannel;
import com.eric.stockapi.models.Payment;
import com.eric.stockapi.repositories.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockConsumerService {
    @Autowired
	private StockRepository stockRepository;
    @Autowired
    private StockChannel stockChannel;
    private Payment paymentReceived;
    @StreamListener(target = StockChannel.paymentInChannel)
   
    public void consumePayment(@Payload Payment payment) {
    	log.info("Payment Processed {}",payment);
    	//monogdb
    	this.paymentReceived=this.stockRepository.findById(payment.getTransactionId()).orElse(null);
 
    
    }
    
    
    public Payment getPaymentDetails() {
    	return this.paymentReceived;
    }
	
	
}
