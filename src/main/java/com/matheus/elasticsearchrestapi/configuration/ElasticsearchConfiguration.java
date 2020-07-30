package com.matheus.elasticsearchrestapi.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfiguration {

	@Value("${elasticsearch.host}")
	private String host;

	@Value("${elasticsearch.port}")
	private int port;

	private Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);

	@Bean(destroyMethod = "close")
	public RestHighLevelClient restClient() {
		this.logger.info("Conexão Elasticsearch Server");
		return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port)));
	}
}
