package com.javajobs.domain.offer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
class OfferFacadeConfiguration {

    @Bean
    OfferFacade offerFacade(OfferFetchable offerFetchable) {
        OfferRepository repo = new OfferRepository() {
            @Override
            public boolean existsByOfferUrl(final String offerUrl) {
                return false;
            }

            @Override
            public Optional<Offer> findByOfferUrl(final String offerUrl) {
                return Optional.empty();
            }

            @Override
            public List<Offer> saveAll(final List<Offer> offers) {
                return List.of();
            }

            @Override
            public List<Offer> findAll() {
                return List.of();
            }

            @Override
            public Optional<Offer> findById(final String id) {
                return Optional.empty();
            }

            @Override
            public Offer save(final Offer offer) {
                return null;
            }
        };

        OfferService offerService = new OfferService(offerFetchable, repo);
        return new OfferFacade(repo, offerService);
    }
}
