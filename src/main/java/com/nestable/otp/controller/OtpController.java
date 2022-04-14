package com.nestable.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestable.otp.model.ResendOtpRequest;
import com.nestable.otp.model.ResendOtpResponse;
import com.nestable.otp.model.SendOtpRequest;
import com.nestable.otp.model.SendOtpResponse;
import com.nestable.otp.model.VerifyOtpRequest;
import com.nestable.otp.model.VerifyOtpResponse;
import com.nestable.otp.service.OtpService;

@RestController
@RequestMapping("/otp")
public class OtpController {
	
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping("/sendOtp")
	public ResponseEntity<SendOtpResponse> sendOtp(@RequestHeader String authorization, @RequestBody SendOtpRequest request)
	{
		SendOtpResponse response =otpService.sendOtp(authorization,request);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/resendOtp")
	public ResponseEntity<ResendOtpResponse> resendOtp(@RequestHeader String authorization, @RequestBody ResendOtpRequest request)
	{
		ResendOtpResponse response =otpService.resendOtp(authorization,request);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/verify")
	public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestHeader String authorization,@RequestBody VerifyOtpRequest request)
	{
		VerifyOtpResponse response= otpService.verifyOtp(authorization, request);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	
	
}
