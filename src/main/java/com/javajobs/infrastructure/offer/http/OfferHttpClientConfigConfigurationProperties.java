package com.javajobs.infrastructure.offer.http;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "offer.http.client.config")
public record OfferHttpClientConfigConfigurationProperties(long connectionTimeout,
                                                           long readTimeout,
                                                           String uri,
                                                           int port) {
}
