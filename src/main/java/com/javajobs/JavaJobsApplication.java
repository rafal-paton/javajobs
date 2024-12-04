package com.javajobs;

import com.javajobs.infrastructure.offer.http.OfferHttpClientConfigConfigurationProperties;
import com.javajobs.infrastructure.security.jwt.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties({OfferHttpClientConfigConfigurationProperties.class, JwtConfigurationProperties.class})
@SpringBootApplication
public class JavaJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaJobsApplication.class, args);
	}

}
