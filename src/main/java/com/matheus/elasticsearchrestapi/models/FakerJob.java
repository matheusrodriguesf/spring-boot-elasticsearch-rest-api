package com.matheus.elasticsearchrestapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FakerJob {
	private String title;
	private String location;
	private String description;
	private String requirements;
	private String benefits;
	private String employmentType;
	private String requiredExperience;
	private String industry;
}
