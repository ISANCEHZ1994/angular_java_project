package com.fullstack.employeemanager.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message); // calling message from the super class
    }
}
