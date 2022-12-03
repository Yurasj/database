package com.rozhan.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Integer id){
        super("Could not find 'review' with id=" + id);
    }
}
