package com.matheus.elasticsearchrestapi.services;

import java.util.List;

import com.matheus.elasticsearchrestapi.models.FakerJob;

public interface FakerJobService {
	public List<FakerJob> searchLocation(String location);
}
