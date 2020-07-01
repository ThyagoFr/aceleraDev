package com.thyago.freitas.apimongodbspring.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersion = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
