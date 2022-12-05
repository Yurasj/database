package com.rozhan.service.impl;

import com.rozhan.domain.Movie;
import com.rozhan.exception.MovieNotFoundException;
import com.rozhan.repository.MovieRepository;
import com.rozhan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;


    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    public Movie create(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Transactional
    public void update(Integer id, Movie uMovie) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        //update
        movie.setName(uMovie.getName());
        movie.setInfo(uMovie.getInfo());
        movie.setCompany(uMovie.getCompany());
        movie.setLanguage(uMovie.getLanguage());
        movie.setActor(uMovie.getActor());
        movie.setAward(uMovie.getAward());
        movieRepository.save(movie);
    }

    @Transactional
    public void delete(Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.delete(movie);
    }

}
