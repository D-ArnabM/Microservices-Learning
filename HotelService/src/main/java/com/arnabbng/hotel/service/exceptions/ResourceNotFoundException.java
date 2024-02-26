package com.arnabbng.hotel.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not Found in the Database !!!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
