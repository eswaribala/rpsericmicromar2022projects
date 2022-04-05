package com.eric.jwtsecurity.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ConfigurationProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaultConfiguration {

	private String key;

	
  
}