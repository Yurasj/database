package com.rozhan.dto.assembler;

import com.rozhan.dto.ReviewDto;
import com.rozhan.controller.ReviewController;
import com.rozhan.domain.Review;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReviewDtoAssembler implements RepresentationModelAssembler<Review, ReviewDto> {
    @Override
    public ReviewDto toModel(Review entity) {
        ReviewDto reviewDto = ReviewDto.builder()
                .id((int)(long)entity.getId())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .movie_id((int)(long)entity.getMovieByMovieId().getId())
                .build();
        Link selfLink = linkTo(methodOn(ReviewController.class).getReview(reviewDto.getId())).withSelfRel();
        reviewDto.add(selfLink);
        return reviewDto;
    }

    @Override
    public CollectionModel<ReviewDto> toCollectionModel(Iterable<? extends Review> entities) {
        CollectionModel<ReviewDto> reviewDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ReviewController.class).getAllReviews()).withSelfRel();
        reviewDtos.add(selfLink);
        return reviewDtos;
    }

    public CollectionModel<ReviewDto> toCollectionModel(Iterable<? extends Review> entities, Link link) {
        CollectionModel<ReviewDto> reviewDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        reviewDtos.add(link);
        return reviewDtos;
    }
}
