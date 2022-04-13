package com.nestable.guestuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateGuestTokenRequest {
	
	private String ipAddress;

}
