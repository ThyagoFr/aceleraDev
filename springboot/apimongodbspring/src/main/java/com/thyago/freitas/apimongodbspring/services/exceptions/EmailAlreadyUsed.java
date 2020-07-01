package com.thyago.freitas.apimongodbspring.services.exceptions;

public class EmailAlreadyUsed extends RuntimeException{

    private static final long serialVersion = 1L;

    public EmailAlreadyUsed(String message) {
        super(message);
    }
}
