package com.rozhan.repository;

import com.rozhan.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Procedure("find_max_rating_by_movie")
    void findMaxRatingByMovieId(Integer movieId);
}