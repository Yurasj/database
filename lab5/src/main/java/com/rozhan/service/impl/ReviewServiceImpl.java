package com.rozhan.service.impl;

import com.rozhan.domain.Review;
import com.rozhan.exception.ReviewNotFoundException;
import com.rozhan.repository.ReviewRepository;
import com.rozhan.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;


    public Review findById(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Transactional
    public Review create(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Transactional
    public void update(Integer id, Review uReview) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
        //update
        review.setComment(uReview.getComment());
        review.setRating(uReview.getRating());
        review.setMovieByMovieId(uReview.getMovieByMovieId());
        reviewRepository.save(review);
    }

    @Transactional
    public void delete(Integer id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
        reviewRepository.delete(review);
    }
}