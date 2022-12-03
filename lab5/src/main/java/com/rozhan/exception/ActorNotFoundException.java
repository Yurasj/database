package com.rozhan.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Integer id){
        super("Could not find 'actor' with id=" + id);
    }
}
