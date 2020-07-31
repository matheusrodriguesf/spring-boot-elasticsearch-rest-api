package com.matheus.elasticsearchrestapi.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public abstract class AbstractElasticsearchService {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RestHighLevelClient client;

	private String indice;

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public <T> QueryBuilder term(String name, T value) {
		return QueryBuilders.termQuery(name, value);
	}

	public <T> QueryBuilder match(String name, T value) {
		return QueryBuilders.matchQuery(name, value);
	}

	public <T> List<T> result(SearchResponse response, Class<T> targetType) {
		List<T> result = new ArrayList<>();
		SearchHit[] searchHits = response.getHits().getHits();
		for (SearchHit hit : searchHits) {
			try {
				result.add(mapper.readValue(hit.getSourceAsString(), targetType));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public SearchResponse search(SearchSourceBuilder sourceBuilder, String... indices) {
		SearchResponse response = new SearchResponse();
		SearchRequest request = new SearchRequest(indices);
		request.source(sourceBuilder);
		try {
			response = client.search(request, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean indiceExist(String indice) throws IOException {
		return client.indices().exists(new GetIndexRequest(indice), RequestOptions.DEFAULT);
	}
}
