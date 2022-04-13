package com.nestable.staticresponse;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaticResponse {

	private Integer status;
	private String message;
}
