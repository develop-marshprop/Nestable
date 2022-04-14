package com.nestable.userpreferences.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Preferences {
	
	private List<String> roomType;
	private List<Area> areas;
	private String city;
	private Long minBudget;
	private Long maxBudget;
	

}
