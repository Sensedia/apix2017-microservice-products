package com.sensedia.apix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

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

	@Bean
	public Swagger2DocumentationConfiguration swagger2Config(){
		return new springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration();
	}

	@Bean
	public SwaggerConfig swaggerConfig(){
		return new SwaggerConfig();
	}
}
