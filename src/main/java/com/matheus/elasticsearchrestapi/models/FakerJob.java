package com.matheus.elasticsearchrestapi.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class FakerJob implements Serializable {
	private String title;
	private String location;
	private String description;
	private String requirements;
	private String benefits;
	private String employmentType;
	private String requiredExperience;
	private String industry;
}
