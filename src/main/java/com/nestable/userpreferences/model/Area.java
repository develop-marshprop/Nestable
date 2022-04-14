package com.nestable.userpreferences.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
	
	private String area;
	private String areaCode;
	private String city;
	private String cityCode;
	private String country;
	

}
