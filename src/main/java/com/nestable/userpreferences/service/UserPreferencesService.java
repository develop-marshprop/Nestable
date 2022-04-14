package com.nestable.userpreferences.service;

import org.springframework.stereotype.Service;

import com.nestable.userpreferences.model.SetPreferenceRequest;
import com.nestable.userpreferences.model.SetPreferenceResponse;

@Service
public class UserPreferencesService {

	public SetPreferenceResponse setPreferences(String authorization, SetPreferenceRequest request) {
		
		SetPreferenceResponse setPreferenceResponse=new SetPreferenceResponse();
		try {
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
		return setPreferenceResponse;
	}

}
