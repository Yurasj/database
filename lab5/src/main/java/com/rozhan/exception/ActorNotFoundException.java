package com.rozhan.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Long id){
        super("Could not find 'actor' with id=" + id);
    }
}
