package com.nestable.otp.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nestable.constant.CommonConstant;
import com.nestable.constant.UserType;
import com.nestable.otp.model.Otp;
import com.nestable.otp.model.ResendOtpRequest;
import com.nestable.otp.model.ResendOtpResponse;
import com.nestable.otp.model.SendOtpRequest;
import com.nestable.otp.model.SendOtpResponse;
import com.nestable.otp.model.VerifyOtpRequest;
import com.nestable.otp.model.VerifyOtpResponse;
import com.nestable.otp.repository.OtpRepository;
import com.nestable.otp.util.SendOtpUtil;
import com.nestable.staticresponse.StaticResponse;
import com.nestable.token.model.Token;
import com.nestable.token.repository.TokenRepository;
import com.nestable.token.util.TokenUtil;
import com.nestable.user.model.User;
import com.nestable.user.repository.UserRepository;
import com.nestable.user.util.UseridGenerationUtil;

@Service
public class OtpService {
	
	
	@Autowired
	private  SendOtpUtil sendOtpUtil;

	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UseridGenerationUtil useridGenerationUtil;
	

	
	//send otp
	public SendOtpResponse sendOtp(String authorization, SendOtpRequest request) {
		
		SendOtpResponse sendOtpResponse= new SendOtpResponse();
		try {
		tokenRepository.findById(authorization).orElseThrow(() -> new RuntimeException());
		String otpString =sendOtpUtil.sendNewOtp(request.getMobileNumber());
		Otp otp= new Otp();
		otp.setMobileNumber(request.getMobileNumber());
		otp.setOtp(otpString);
		otp.setToken(authorization);
		otp.setGenerationTime(new Date());
		otp.setIsVerified(false);
		otpRepository.save(otp);
		
		sendOtpResponse.setMobileNumber(request.getMobileNumber());
		sendOtpResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
		sendOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			sendOtpResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_ERROR);
			sendOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		return sendOtpResponse;
	}
	
	//resend otp

	public ResendOtpResponse resendOtp(String authorization, ResendOtpRequest request) {
		
		ResendOtpResponse resendOtpResponse= new ResendOtpResponse();
		try {
		tokenRepository.findById(authorization).orElseThrow(() -> new RuntimeException());
		Optional<Otp> optional = otpRepository.findById(authorization);
		Otp existingOtp = optional.get();
		if(existingOtp.getIsVerified()==true)
		{
			String otpString =sendOtpUtil.sendNewOtp(request.getMobileNumber());
			existingOtp.setOtp(otpString);
			existingOtp.setGenerationTime(new Date());
			existingOtp.setIsVerified(false);
			otpRepository.save(existingOtp);
		}
		else
		{
			sendOtpUtil.sendExistingOtp(existingOtp.getOtp(),existingOtp.getMobileNumber());
			
		}	
		
		
		resendOtpResponse.setMobileNumber(request.getMobileNumber());
		resendOtpResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
		resendOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			resendOtpResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_ERROR);
			resendOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		return resendOtpResponse;
	}
	
	
	
	

	public VerifyOtpResponse verifyOtp(String authorization, VerifyOtpRequest request) {
		
		VerifyOtpResponse verifyOtpResponse =new VerifyOtpResponse();
		try {
		Optional<Otp> optional = otpRepository.findById(authorization);
		tokenRepository.findById(authorization).orElseThrow(() -> new RuntimeException());
		Otp otp=optional.get();
		if(otp.getOtp().equals(request.getOtp()))
		{   
			//generate new token
			String tokenString = tokenUtil.generateToken();
			otp.setIsVerified(true);
			otp.setToken(tokenString);
			otpRepository.save(otp);
			
			//generating userid			
			Long id=Long.valueOf("22000000000");
			Integer sequenceNumber = useridGenerationUtil.getSequenceNumber(User.SEQUENCE_NAME);
			Long longSequenceNumber = Long.valueOf(sequenceNumber);
			 id= id + longSequenceNumber;
			 String userId=Long.toString(id);
			
			//updating token collection
			Optional<Token> optionaltoken = tokenRepository.findById(authorization);
			Token token=optionaltoken.get();
			token.setToken(tokenString);
			token.setTokenGenarationTime(new Date());
			token.setUserid(userId);
			token.setUserType(UserType.BUYER);
			tokenRepository.save(token);
			
			//saving user into db
			User user= new User();
			user.setUserId(userId);
			user.setUserType(UserType.BUYER);
			user.setMobileNumber(request.getMobileNumber());
			user.setToken(tokenString);
			userRepository.save(user);
			
			verifyOtpResponse.setMessage("otp verified successfully");
			verifyOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
			verifyOtpResponse.setUserId(userId);
			verifyOtpResponse.setUpdatedToken(tokenString);
			
			
		}
		else
		{
			
			verifyOtpResponse.setMessage("otp not verified ");
			verifyOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_FAILURE);
		}
		}
		catch (Exception e) 
		{
           e.printStackTrace();
           verifyOtpResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_ERROR);
           verifyOtpResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		return verifyOtpResponse;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
