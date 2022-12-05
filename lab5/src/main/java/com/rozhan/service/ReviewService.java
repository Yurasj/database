package com.rozhan.service;

import com.rozhan.domain.Review;

import java.util.List;

public interface ReviewService extends GeneralService<Review, Integer> {
    void findMaxRatingByMovieId(Integer movieId);
}
