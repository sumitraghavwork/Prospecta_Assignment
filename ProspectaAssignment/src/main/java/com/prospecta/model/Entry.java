package com.prospecta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
	
	private String title;
	
	private String description;
	
	private String auth;
	
	private boolean https;
	
	private String cors;
	
	private String category;

}
