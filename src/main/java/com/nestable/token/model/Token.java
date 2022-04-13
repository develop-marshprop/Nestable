package com.nestable.token.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tokens")
public class Token {
	
	@Id	
	private String token;
	private String ipAddress;
	private String userid;
	private String userType;
	private Date tokenGenarationTime;


}
