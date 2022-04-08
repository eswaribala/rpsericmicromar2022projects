package com.eric.circuitbreaker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eric.circuitbreaker.handlers.CBHandler;
import com.eric.circuitbreaker.models.JWTRequest;

import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;


@RestController
public class CBController {
    @Autowired
	private CBHandler cbHandler;
    @Autowired
    private JaegerTracer tracer;
    
	@PostMapping("/")
	public ResponseEntity<?> sendRequest(@RequestBody JWTRequest jwtRequest) {
		Span span = tracer.buildSpan("Prefilter ...").start();
		
		 ResponseEntity<String> responseEntity= this.cbHandler.requestHandler(jwtRequest,span);
		 span.finish();
		 return responseEntity;
	}
}
