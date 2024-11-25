package com.javajobs.infrastructure.offer.controller;

import com.javajobs.domain.offer.OfferFacade;
import com.javajobs.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/offers")
@AllArgsConstructor
class OfferRestController {

    private final OfferFacade offerFacade;

    @GetMapping
    public ResponseEntity<List<OfferResponseDto>> findALlOffers() {
        List<OfferResponseDto> allOffers = offerFacade.findAllOffers();
        log.info("GET request received!");
        return ResponseEntity.ok(allOffers);
    }
}
