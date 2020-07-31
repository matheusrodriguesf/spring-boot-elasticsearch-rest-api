package com.matheus.elasticsearchrestapi.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.elasticsearchrestapi.base.ConstantsApi;
import com.matheus.elasticsearchrestapi.models.FakerJob;
import com.matheus.elasticsearchrestapi.services.FakerJobServiceImpl;

@RestController
@RequestMapping(ConstantsApi.V1 + "/faker-job")
public class FakerJobRestController {

	@Autowired
	private FakerJobServiceImpl service;

	@RequestMapping(method = RequestMethod.GET, path = "/{indice}/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FakerJob> getByLocation(@PathVariable("indice") String indice,
			@PathVariable("location") String location) {
		service.setIndice(indice);
		List<FakerJob> fakerJobs = service.searchLocation(location);
		return fakerJobs;
	}
}
