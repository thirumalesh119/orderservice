package com.myProject.orderservice.Exceptions;

import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class ControllerAdviceClass {

@ExceptionHandler(OrderInValidException.class)
    public ResponseEntity<Object> orderInvalidException(OrderInValidException ex, WebRequest req){

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}
}
