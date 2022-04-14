package com.nestable.status.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nestable.constant.CommonConstant;
import com.nestable.status.model.UpdateUserStatusRequest;
import com.nestable.status.model.UpdateUserStatusResponse;
import com.nestable.status.model.UserStatus;
import com.nestable.status.repository.UserStatusRepository;
import com.nestable.token.repository.TokenRepository;

@Service
public class UserStatusService {
	@Autowired
	private UserStatusRepository userStatusRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	public UpdateUserStatusResponse updateUserStatus(String authorization, UpdateUserStatusRequest request) {
		
		UpdateUserStatusResponse updateUserStatusResponse = new UpdateUserStatusResponse();
		
		try {		
		tokenRepository.findById(authorization).orElseThrow(() -> new RuntimeException());
		UserStatus userStatus=new UserStatus();
		userStatus.setPageName(request.getPageName());
		userStatus.setStatus(request.getStatus());
		userStatus.setToken(authorization);
		userStatusRepository.save(userStatus);
		
		updateUserStatusResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
		updateUserStatusResponse.setStatus(CommonConstant.RESPONSE_STATUS_SUCCESS);
		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			updateUserStatusResponse.setMessage(CommonConstant.RESPONSE_MESSAGE_ERROR);
			updateUserStatusResponse.setStatus(CommonConstant.RESPONSE_STATUS_ERROR);
		}
		return updateUserStatusResponse;
		
	}

}
