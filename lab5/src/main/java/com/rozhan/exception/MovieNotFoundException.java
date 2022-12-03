package com.rozhan.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Integer id){
        super("Could not find 'movie' with id=" + id);
    }
}