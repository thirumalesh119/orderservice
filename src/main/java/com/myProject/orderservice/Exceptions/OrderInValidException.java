package com.myProject.orderservice.Exceptions;

public class OrderInValidException extends Exception {


    public OrderInValidException(){
        super();
    }

    public OrderInValidException(String message){
        super(message);
    }
}
