package com.eric.inventoryapi.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom-beanlist")
public class CustomBeanEndPoint {
    @Autowired
	private ApplicationContext applicationContext;
    
    
    @Bean
	public String message()
	{
		return "Critical Message from Inventory Service.....";
	}
	
	@ReadOperation
	@Bean
	public String[] getAllRegBeanNames()
	{
		
		return applicationContext.getBeanDefinitionNames();

       
	}

	
}
