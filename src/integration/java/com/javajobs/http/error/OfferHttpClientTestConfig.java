package com.javajobs.http.error;

import com.javajobs.domain.offer.OfferFetchable;
import com.javajobs.infrastructure.offer.http.OfferHttpClientConfig;
import org.springframework.web.client.RestTemplate;

import static com.javajobs.BaseIntegrationTest.WIRE_MOCK_HOST;

public class OfferHttpClientTestConfig extends OfferHttpClientConfig {
    public OfferFetchable remoteOfferTestClient(int port, int connectionTimeout, int readTimeout) {
        final RestTemplate restTemplate = restTemplate(connectionTimeout, readTimeout, restTemplateResponseErrorHandler());
        return remoteOfferClient(restTemplate, WIRE_MOCK_HOST, port);
    }
}