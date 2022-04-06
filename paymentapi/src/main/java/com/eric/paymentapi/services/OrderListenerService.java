package com.eric.paymentapi.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.eric.paymentapi.channels.PaymentChannel;
import com.eric.paymentapi.models.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderListenerService {
	
	@StreamListener(target = PaymentChannel.inChannel)
	public void consumeOrder(@Payload Order order) {
		
		 log.info("Received Order details: {}",order);

	}

}
