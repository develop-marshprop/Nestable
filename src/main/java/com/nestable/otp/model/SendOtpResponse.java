package com.nestable.otp.model;

import com.nestable.staticresponse.StaticResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendOtpResponse extends StaticResponse{

	private String mobileNumber;
}
