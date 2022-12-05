package com.rozhan.controller.impl;

import com.rozhan.controller.MovieController;
import com.rozhan.domain.Movie;
import com.rozhan.controller.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieControllerImpl implements MovieController {
    @Autowired
    private MovieService movieService;

    @Override
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieService.findById(id);
    }

    @Override
    public int create(Movie movie) {
        return movieService.create(movie);
    }

    @Override
    public int update(Integer id, Movie movie) {
        return movieService.update(id, movie);
    }

    @Override
    public int delete(Integer id) {
        return movieService.delete(id);
    }
}
