package com.rozhan.exception;


public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Integer id){
        super("Could not find 'company' with id=" + id);
    }
}
