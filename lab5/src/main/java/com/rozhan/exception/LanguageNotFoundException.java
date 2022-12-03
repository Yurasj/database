package com.rozhan.exception;

public class LanguageNotFoundException extends RuntimeException {
    public LanguageNotFoundException(Integer id){
        super("Could not find 'language' with id=" + id);
    }
}
