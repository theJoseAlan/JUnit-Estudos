package com.example.demo.services.exceptions;


public class ObjectNotfoundException extends RuntimeException{

    public ObjectNotfoundException(String menssagem){
        super(menssagem);
    }

}
