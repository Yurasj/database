package com.rozhan.dao.impl;

import com.rozhan.dao.ReviewDao;
import com.rozhan.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReviewDaoImpl implements ReviewDao{
    private static final String FIND_ALL = "SELECT * FROM review";
    private static final String CREATE = "INSERT review(comment, rating, movie_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE review SET comment=?, rating=?, movie_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM review WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM review WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Review> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Review.class));
    }

    @Override
    public Optional<Review> findById(Integer id) {
        Optional<Review> review;
        try {
            review = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Review.class), id));
        } catch (EmptyResultDataAccessException e) {
            review = Optional.empty();
        }
        return review;
    }

    @Override
    public int create(Review review) {
        return jdbcTemplate.update(CREATE, review.getComment(), review.getRating(), review.getMovie_id());
    }

    @Override
    public int update(Integer id, Review review) {
        return jdbcTemplate.update(UPDATE, review.getComment(), review.getRating(), review.getMovie_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
