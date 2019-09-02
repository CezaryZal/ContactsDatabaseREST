package com.CezaryZal.rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(ContactNotFoundException exc) {

        ContactErrorResponse eror = new ContactErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(eror, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(Exception exc) {

        ContactErrorResponse eror = new ContactErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(eror, HttpStatus.BAD_REQUEST);
    }
}
