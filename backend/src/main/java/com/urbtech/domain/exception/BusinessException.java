package com.urbtech.domain.exception;

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinessException(String mesnagem){
        super(mesnagem);
    }

}