package com.javajobs.infrastructure.offer.controller.error;

import org.springframework.http.HttpStatus;

record OfferErrorResponse(String message, HttpStatus status) {
}
