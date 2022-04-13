package com.nestable.guestuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestable.guestuser.model.GenerateGuestTokenRequest;
import com.nestable.guestuser.model.GenerateGuestTokenResponse;
import com.nestable.guestuser.service.GuestUserService;
import com.nestable.staticresponse.StaticResponse;

@RestController
@RequestMapping("/guestUser")
public class GuestUserController {
	
	@Autowired
	private GuestUserService guestUserService;
	
	//generate guest token api
	@PostMapping("/generateGuestToken")
	public GenerateGuestTokenResponse  generateGuestToken(@RequestBody GenerateGuestTokenRequest request)
	{
		return guestUserService.generateGuestToken(request);
		
		
	}
	

}
