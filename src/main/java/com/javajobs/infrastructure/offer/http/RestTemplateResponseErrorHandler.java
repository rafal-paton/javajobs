package com.javajobs.infrastructure.offer.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        final HttpStatusCode statusCode = httpResponse.getStatusCode();
        final HttpStatus status = HttpStatus.resolve(statusCode.value());
        if (status != null) {
            if (status.is5xxServerError()) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while using http client");
            } else if (status.is4xxClientError()) {
                if (status == HttpStatus.NOT_FOUND) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else if (status == HttpStatus.UNAUTHORIZED) {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                }
            }
        }
    }
}