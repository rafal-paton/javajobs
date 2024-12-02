package com.javajobs.domain.offer;

import com.javajobs.domain.offer.dto.JobOfferResponse;
import com.javajobs.domain.offer.dto.OfferRequestDto;
import com.javajobs.domain.offer.dto.OfferResponseDto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class OfferFacadeTest {
    @Test
    public void should_fetch_from_jobs_from_remote_and_save_all_offers_when_repository_is_empty() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration().offerFacadeForTests();
        assertThat(offerFacade.findAllOffers()).isEmpty();
        // when
        List<OfferResponseDto> result = offerFacade.fetchAllOffersAndSaveAllIfNotExists();
        // then
        assertThat(result).hasSize(6);
    }

    @Test
    public void should_save_only_2_offers_when_repository_had_4_added_with_offer_urls() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(
                List.of(
                        new JobOfferResponse("Java Developer", "Microsoft", "12000", "someurl.pl/1"),
                        new JobOfferResponse("Junior Developer", "Google", "14000", "someurl.pl/2"),
                        new JobOfferResponse("Software Developer", "Apple", "12000", "someurl.pl/3"),
                        new JobOfferResponse("Junior Developer", "Tesla", "8000", "someurl.pl/4"),
                        new JobOfferResponse("Junior", "Comarch", "10000", "someurl.pl/5"),
                        new JobOfferResponse("Developer", "Finanteq", "9000", "someurl.pl/6")
                )
        ).offerFacadeForTests();
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/1"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/2"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/3"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/4"));
        assertThat(offerFacade.findAllOffers()).hasSize(4);
        // when
        List<OfferResponseDto> response = offerFacade.fetchAllOffersAndSaveAllIfNotExists();
        // then
        assertThat(List.of(
                        response.get(0).offerUrl(),
                        response.get(1).offerUrl()
                )
        ).containsExactlyInAnyOrder("someurl.pl/5", "someurl.pl/6");
    }

    @Test
    public void should_save_4_offers_when_there_are_no_offers_in_database() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
        // when
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/1"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/2"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/3"));
        offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "someurl.pl/4"));
        // then
        assertThat(offerFacade.findAllOffers()).hasSize(4);
    }

    @Test
    public void should_find_offer_by_id_when_offer_was_saved() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(new OfferRequestDto("Microsoft", "Java Developer", "10000", "someurl.pl/1"));
        // when
        OfferResponseDto offerById = offerFacade.findOfferById(offerResponseDto.id());
        // then
        assertThat(offerById).isEqualTo(OfferResponseDto.builder()
                .id(offerResponseDto.id())
                .companyName("Microsoft")
                .position("Java Developer")
                .salary("10000")
                .offerUrl("someurl.pl/1")
                .build()
        );
    }

    @Test
    public void should_throw_not_found_exception_when_offer_not_found() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
        assertThat(offerFacade.findAllOffers()).isEmpty();
        // when
        Throwable thrown = catchThrowable(() -> offerFacade.findOfferById("100"));

        // then
        AssertionsForClassTypes.assertThat(thrown)
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer with id 100 not found");
    }

    @Test
    public void should_throw_duplicate_key_exception_when_with_offer_url_exists() {
        // given
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(new OfferRequestDto("someName", "somePosition", "someSalary", "url.pl"));
        String savedId = offerResponseDto.id();
        assertThat(offerFacade.findOfferById(savedId).id()).isEqualTo(savedId);
        // when
        Throwable thrown = catchThrowable(() -> offerFacade.saveOffer(
                new OfferRequestDto("someName", "somePosition", "someSalary", "url.pl")));
        // then
        AssertionsForClassTypes.assertThat(thrown)
                .isInstanceOf(DuplicateKeyException.class)
                .hasMessage("Offer with offerUrl [url.pl] already exists");
    }
}