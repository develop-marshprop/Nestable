package com.nestable.guestuser.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nestable.constant.CommonConstant;
import com.nestable.constant.UserType;
import com.nestable.guestuser.model.GenerateGuestTokenRequest;
import com.nestable.guestuser.model.GenerateGuestTokenResponse;
import com.nestable.token.model.Token;
import com.nestable.token.repository.TokenRepository;
import com.nestable.token.util.TokenUtil;

@Service
public class GuestUserService {
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private TokenRepository tokenRepository;

	
	  ///generating Guest Token service
	public GenerateGuestTokenResponse generateGuestToken(GenerateGuestTokenRequest request) {
		GenerateGuestTokenResponse generateGuestTokenResponse= new GenerateGuestTokenResponse();
		try {
		//generating token
		 Token token =new Token();
		 String tokenString = tokenUtil.generateToken();
		 token.setToken(tokenString);	
		 token.setIpAddress(request.getIpAddress());
		 token.setTokenGenarationTime(new Date());
		 token.setUserType(UserType.GUEST);
		 tokenRepository.save(token);
		 
		 generateGuestTokenResponse.setToken(tokenString);
		 generateGuestTokenResponse.setMessage(CommonConstant.MESSAGE_STATUS_SUCCESS);
		 generateGuestTokenResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			generateGuestTokenResponse.setMessage(CommonConstant.MESSAGE_STATUS_ERROR);
			generateGuestTokenResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		return generateGuestTokenResponse;
		
	}

}
