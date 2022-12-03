package com.rozhan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "review", collectionRelation = "reviews")
public class ReviewDto extends RepresentationModel<ReviewDto> {
    private final int id;
    private final String comment;
    private final int rating;
    private final int movie_id;
}
