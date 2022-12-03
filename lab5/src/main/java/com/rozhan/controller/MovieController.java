package com.rozhan.controller;

import com.rozhan.domain.Movie;
import com.rozhan.dto.MovieDto;
import com.rozhan.dto.assembler.MovieDtoAssembler;
import com.rozhan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieDtoAssembler movieDtoAssembler;

    @GetMapping(value = "/{movieId}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Integer movieId) {
        Movie movie = movieService.findById(movieId);
        MovieDto movieDto = movieDtoAssembler.toModel(movie);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<MovieDto>> getAllMovies() {
        List<Movie> movies = movieService.findAll();
        CollectionModel<MovieDto> movieDtos = movieDtoAssembler.toCollectionModel(movies);
        return new ResponseEntity<>(movieDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<MovieDto> addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.create(movie);
        MovieDto movieDto = movieDtoAssembler.toModel(newMovie);
        return new ResponseEntity<>(movieDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{movieId}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie uMovie, @PathVariable Integer movieId) {
        movieService.update(movieId, uMovie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer movieId) {
        movieService.delete(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
