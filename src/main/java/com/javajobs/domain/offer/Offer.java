package com.javajobs.domain.offer;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Document("offers")
record Offer(
        @Id  String id,
        @Field("company") String companyName,
        @Field("position") String position,
        @Field("url") String salary,
        @Indexed(unique = true) String offerUrl) {
}
