package com.sensedia.apix;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApixProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApixProductsApplication.class, args);
	}

	@Bean
	public OkHttpClient clientHttp() {
		return new OkHttpClient();
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}
