package com.rozhan.controller.impl;

import com.rozhan.controller.ReviewController;
import com.rozhan.domain.Review;
import com.rozhan.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewControllerImpl implements ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Override
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewService.findById(id);
    }

    @Override
    public int create(Review review) {
        return reviewService.create(review);
    }

    @Override
    public int update(Integer id, Review review) {
        return reviewService.update(id, review);
    }

    @Override
    public int delete(Integer id) {
        return reviewService.delete(id);
    }
}
