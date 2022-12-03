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
@Relation(itemRelation = "movie", collectionRelation = "movies")
public class MovieDto extends RepresentationModel<MovieDto> {
    private final int id;
    private final String name;
    private final String info;
    private final int company_id;
    private final int language_id;
    private final int actor_id;
    private final int award_id;
}
