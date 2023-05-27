package com.urbtech.api.mapper;

import com.urbtech.api.exceptionhandler.Problema;
import com.urbtech.domain.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ProblemaMapper {

    public Problema httpStatusToProblema(HttpStatus httpStatus, RuntimeException ex){
        Problema problema = new Problema();
        problema.setStatus(httpStatus.value());
        problema.setDescricao(ex.getMessage());
        problema.setDataHora(LocalDateTime.now());

        return problema;
    }

}