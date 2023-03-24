package com.danfoss.flightmanager.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FlightManagerRepositoryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {FlightManagerRepositoryException.class})
    protected ResponseEntity handleNotFound(RuntimeException ex, WebRequest webRequest){

        return handleExceptionInternal(ex, "Flight manager application error occured", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }
}
