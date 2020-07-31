package com.matheus.elasticsearchrestapi.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.stereotype.Service;

import com.matheus.elasticsearchrestapi.base.AbstractElasticsearchService;
import com.matheus.elasticsearchrestapi.models.FakerJob;

@Service
public class FakerJobServiceImpl extends AbstractElasticsearchService implements FakerJobService {

	@Override
	public List<FakerJob> searchLocation(String location) {
		QueryBuilder query = this.match("location", location);
		SearchSourceBuilder sourceBuilder = sourceBuilder(query);
		SearchResponse response = this.search(sourceBuilder, getIndice());
		List<FakerJob> result = result(response, FakerJob.class);
		return result;
	}

	private SearchSourceBuilder sourceBuilder(QueryBuilder query) {
		return new SearchSourceBuilder().query(query).timeout(new TimeValue(60, TimeUnit.SECONDS));
	}

}
