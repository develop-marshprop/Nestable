package com.nestable.token.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
public String generateToken() {
		
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString();
	}

}
