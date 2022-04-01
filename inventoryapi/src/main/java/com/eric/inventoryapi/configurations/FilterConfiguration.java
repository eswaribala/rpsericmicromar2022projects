package com.eric.inventoryapi.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eric.inventoryapi.filters.InventoryFilter;

@Configuration
public class FilterConfiguration {
	
	@Bean
	public FilterRegistrationBean<InventoryFilter> register()
	{
		FilterRegistrationBean<InventoryFilter> reg=new 
				FilterRegistrationBean<InventoryFilter>();
		InventoryFilter filter =new InventoryFilter();
		reg.setFilter(filter);
		reg.addUrlPatterns("/categories/*");
		reg.setOrder(1);
		return reg;
	}


}
