package com.nestable.status.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestable.status.model.UpdateUserStatusRequest;
import com.nestable.status.model.UpdateUserStatusResponse;
import com.nestable.status.service.UserStatusService;

@RestController
@RequestMapping("/userStatus")
public class UserStatusController {
	
	@Autowired
	private UserStatusService userStatusService;
	
	@PostMapping("/updateUserStatus")
	public ResponseEntity<UpdateUserStatusResponse> updateUserStatus(@RequestHeader String authorization, @RequestBody UpdateUserStatusRequest request)
	{
		UpdateUserStatusResponse response = userStatusService.updateUserStatus(authorization, request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
