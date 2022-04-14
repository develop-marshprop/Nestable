package com.nestable.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nestable.user.model.CreateProfileRequest;
import com.nestable.user.model.CreateProfileResponse;
import com.nestable.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createProfile")
	public ResponseEntity<CreateProfileResponse> createProfile(@RequestHeader String  authorization, @RequestBody CreateProfileRequest request )
	{
		CreateProfileResponse response=userService.createProfile(authorization,request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
