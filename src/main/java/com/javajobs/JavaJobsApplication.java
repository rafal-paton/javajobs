package com.javajobs;

import com.javajobs.infrastructure.offer.http.OfferHttpClientConfigConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(OfferHttpClientConfigConfigurationProperties.class)
@SpringBootApplication
public class JavaJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaJobsApplication.class, args);
	}

}
