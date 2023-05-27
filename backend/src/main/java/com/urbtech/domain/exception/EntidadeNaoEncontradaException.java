package com.urbtech.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    private static  final long serialVersionUID = 1;
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}