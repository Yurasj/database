package com.rozhan.service.impl;

import com.rozhan.dao.ReviewDao;
import com.rozhan.domain.Review;
import com.rozhan.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewDao.findById(id);
    }

    @Override
    public int create(Review review) {
        return reviewDao.create(review);
    }

    @Override
    public int update(Integer id, Review review) {
        return reviewDao.update(id, review);
    }

    @Override
    public int delete(Integer id) {
        return reviewDao.delete(id);
    }

}
