package com.dailycodebuffer.spring.data.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

@Configuration
public class ESConfig {

	@Bean
	public JestClient jestClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://" + "192.168.181.119" + ":9200")
				.multiThreaded(true)
				.connTimeout(1000 * 60 * 10)
				.readTimeout(1000 * 60 * 10)
				.defaultMaxTotalConnectionPerRoute(100)
				.maxTotalConnection(200)
				.build());
		
		JestClient client = factory.getObject();
		return client;
	}
}
