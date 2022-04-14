package com.nestable.otp.util;

import java.text.DecimalFormat;
import java.util.Random;
import org.springframework.stereotype.Component;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class SendOtpUtil {
	
	public String sendNewOtp(String mob_no)
	{
		String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
		try {
			HttpResponse response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
					  .header("authorization", "itHh2lvBkCqme7XugpFSTJwr0YfMInU6j3cs1DaREKyNP9d5zoki4rNen1P3lGa9FZBLTWSHcAKE5O6U")
					  .header("Content-Type", "application/x-www-form-urlencoded")
					  .body("variables_values="+otp+"&route=otp&numbers="+mob_no)
					  .asString();
		} catch (UnirestException e) {
			
			e.printStackTrace();
		}
		return otp;
	}
	
	
	
	
	public String sendExistingOtp(String otp,String mob_no)
	{
		
		try {
			HttpResponse response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
					  .header("authorization", "itHh2lvBkCqme7XugpFSTJwr0YfMInU6j3cs1DaREKyNP9d5zoki4rNen1P3lGa9FZBLTWSHcAKE5O6U")
					  .header("Content-Type", "application/x-www-form-urlencoded")
					  .body("variables_values="+otp+"&route=otp&numbers="+mob_no)
					  .asString();
		} catch (UnirestException e) {
			
			e.printStackTrace();
		}
		return otp;
	}

}
