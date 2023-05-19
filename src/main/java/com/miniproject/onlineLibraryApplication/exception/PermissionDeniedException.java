package com.miniproject.onlineLibraryApplication.exception;

public class PermissionDeniedException extends RuntimeException{
    public PermissionDeniedException (String errorMessage){
        super(errorMessage);
    }
}
