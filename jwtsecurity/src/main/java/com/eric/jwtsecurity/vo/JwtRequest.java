package com.eric.jwtsecurity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

	private String userName;
	private String userPwd;
	

	
}
