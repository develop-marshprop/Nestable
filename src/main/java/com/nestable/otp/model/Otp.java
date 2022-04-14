package com.nestable.otp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "otp")
public class Otp {
	
	@Id
	private String token;
	private String mobileNumber;
	private String otp;
	private Date generationTime;
	private Boolean isVerified;

}
