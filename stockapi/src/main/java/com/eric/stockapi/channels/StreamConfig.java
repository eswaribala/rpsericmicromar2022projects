package com.eric.stockapi.channels;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(StockChannel.class)
public class StreamConfig {

}
