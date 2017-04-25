package com.sensedia.apix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class ApixProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApixProductsApplication.class, args);
	}
}
