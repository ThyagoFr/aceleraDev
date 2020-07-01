package com.thyago.freitas.apimongodbspring.controllers.exceptions;
import com.thyago.freitas.apimongodbspring.services.exceptions.EmailAlreadyUsed;
import com.thyago.freitas.apimongodbspring.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(System.currentTimeMillis(),status.value(),error.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailAlreadyUsed.class)
    public ResponseEntity<StandartError> emailAlreadyUsed(EmailAlreadyUsed error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandartError err = new StandartError(System.currentTimeMillis(),status.value(),error.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
