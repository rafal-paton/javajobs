package com.javajobs.domain.offer;

import com.javajobs.domain.offer.dto.JobOfferResponse;

import java.util.List;

public interface OfferFetchable {
    List<JobOfferResponse> fetchOffers();
}
