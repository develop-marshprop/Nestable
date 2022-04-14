package com.nestable.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nestable.staticresponse.StaticResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
	
	
	@Transient   //so that it will not persist in db
	public static final String SEQUENCE_NAME="User_sequence";
	@Id
   private String userId;
   private String userType;
   private String name;
   private Integer age;
   private String profession;
   private String mobileNumber;
   private String token;
   
   

}
