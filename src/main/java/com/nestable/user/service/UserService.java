package com.nestable.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nestable.constant.CommonConstant;
import com.nestable.staticresponse.StaticResponse;
import com.nestable.token.model.Token;
import com.nestable.token.repository.TokenRepository;
import com.nestable.user.model.CreateProfileRequest;
import com.nestable.user.model.CreateProfileResponse;
import com.nestable.user.model.User;
import com.nestable.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private UserRepository userRepository;

	public CreateProfileResponse createProfile(String authorization, CreateProfileRequest request) {
		
		CreateProfileResponse createProfileResponse=new CreateProfileResponse();
		try {
		Optional<Token> optionaltoken = tokenRepository.findById(authorization);
		Token token = optionaltoken.get();
		
		Optional<User> optionaluser = userRepository.findById(token.getUserid()) ;
		User user = optionaluser.get();
		user.setAge(request.getAge());
		user.setName(request.getName());
		user.setProfession(request.getProfession());
		userRepository.save(user);
		
		createProfileResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
		createProfileResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
		}
		catch (Exception e) {
			e.printStackTrace();
			createProfileResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_ERROR);
			createProfileResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		
		return createProfileResponse;
	}

}
