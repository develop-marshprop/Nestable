package com.nestable.guestuser.model;

import com.nestable.staticresponse.StaticResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GenerateGuestTokenResponse extends StaticResponse {

	
	private String token;
}
