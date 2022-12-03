package com.rozhan.dto.assembler;

import com.rozhan.dto.MovieDto;
import com.rozhan.controller.MovieController;
import com.rozhan.domain.Movie;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class MovieDtoAssembler implements RepresentationModelAssembler<Movie, MovieDto> {
    @Override
    public MovieDto toModel(Movie entity) {
        MovieDto movieDto = MovieDto.builder()
                .id((int)(long)entity.getId())
                .name(entity.getName())
                .info(entity.getInfo())
                .company_id((int)(long)entity.getCompany().getId())
                .language_id((int)(long)entity.getLanguage().getId())
                .actor_id((int)(long)entity.getActor().getId())
                .award_id((int)(long)entity.getAward().getId())
                .build();
        Link selfLink = linkTo(methodOn(MovieController.class).getMovie(movieDto.getId())).withSelfRel();
        movieDto.add(selfLink);
        return movieDto;
    }

    @Override
    public CollectionModel<MovieDto> toCollectionModel(Iterable<? extends Movie> entities) {
        CollectionModel<MovieDto> movieDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(MovieController.class).getAllMovies()).withSelfRel();
        movieDtos.add(selfLink);
        return movieDtos;
    }

    public CollectionModel<MovieDto> toCollectionModel(Iterable<? extends Movie> entities, Link link) {
        CollectionModel<MovieDto> movieDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        movieDtos.add(link);
        return movieDtos;
    }
}
