package com.matheus.elasticsearchrestapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfiguration {
	@Bean
	public Jackson2ObjectMapperBuilder custom() {
		return new Jackson2ObjectMapperBuilder()
				.failOnEmptyBeans(false)
				.failOnUnknownProperties(false);
	}
}
