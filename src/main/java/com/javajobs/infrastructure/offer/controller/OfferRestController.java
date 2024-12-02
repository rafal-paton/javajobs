package com.javajobs.infrastructure.offer.controller;

import com.javajobs.domain.offer.OfferFacade;
import com.javajobs.domain.offer.dto.OfferRequestDto;
import com.javajobs.domain.offer.dto.OfferResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<OfferResponseDto> findOfferById(@PathVariable String id) {
        OfferResponseDto offerById = offerFacade.findOfferById(id);
        return ResponseEntity.ok(offerById);
    }

    @PostMapping
    public ResponseEntity<OfferResponseDto> saveOffer(@RequestBody @Valid OfferRequestDto offerDto) {
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(offerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(offerResponseDto);
    }
}
