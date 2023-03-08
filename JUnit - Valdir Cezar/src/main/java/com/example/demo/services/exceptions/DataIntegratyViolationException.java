package com.example.demo.services.exceptions;


public class DataIntegratyViolationException extends RuntimeException{

    public DataIntegratyViolationException(String menssagem){
        super(menssagem);
    }

}
