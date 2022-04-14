package com.nestable.userpreferences.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestable.userpreferences.model.SetPreferenceRequest;
import com.nestable.userpreferences.model.SetPreferenceResponse;
import com.nestable.userpreferences.service.UserPreferencesService;

@RestController
@RequestMapping("/preference")
public class UserPreferencesController {
	
	@Autowired
	private  UserPreferencesService userPreferencesService ;
	
	public ResponseEntity<SetPreferenceResponse> setPreferences(@RequestHeader String authorization, @RequestBody SetPreferenceRequest request)
   	{
		
		SetPreferenceResponse response =userPreferencesService.setPreferences(authorization,request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
