package com.eric.stockapi.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface StockChannel {
	String paymentInChannel="payment-in";
	@Input(paymentInChannel)
	MessageChannel InChannel();

}
