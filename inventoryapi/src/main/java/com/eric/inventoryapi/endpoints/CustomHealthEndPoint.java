package com.eric.inventoryapi.endpoints;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.eric.inventoryapi.repositories.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Endpoint(id = "custom-healthlist")
public class CustomHealthEndPoint {
//implements HealthIndicator{
   
	private DataSourceBuilder dataSourceBuilder;

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.username}")
    private String userName;     
	@Value("${spring.datasource.password}")
    private String password; 
	
	
	@Bean
	//creating db connection
	 
    public DataSource getDataSource()
    {
    	log.info("Entering Given Env.....");
       
    	dataSourceBuilder=DataSourceBuilder.create();
    	dataSourceBuilder.url(dbUrl);
    	dataSourceBuilder.username(userName);
    	dataSourceBuilder.password(password);
    	dataSourceBuilder.driverClassName(driver);
    	return dataSourceBuilder.build();
   	
    }
	
	@ReadOperation
	@Bean
	public Health getHealth() {
		Health health=null;
		try {
			if(getDataSource().getConnection() != null)
				health=Health.up().withDetail("message", "Available").build();
			else
				 health= Health.down().withDetail("message", "Not Available").build();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	return health;
		
	}

	
         
	
}
