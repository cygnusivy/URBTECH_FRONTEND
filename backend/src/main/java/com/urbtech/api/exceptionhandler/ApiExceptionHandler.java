package com.urbtech.api.exceptionhandler;

import com.urbtech.api.mapper.ProblemaMapper;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;
    private ProblemaMapper problemaMapper;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Problema.Field> fieldList = new ArrayList<>();

        for (ObjectError e : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) e).getField();
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());

            fieldList.add(new Problema.Field(nome, mensagem));
        }

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(LocalDateTime.now());
        problema.setDescricao("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        problema.setFilds(fieldList);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> hand(BusinessException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return  handleExceptionInternal(ex, problemaMapper.httpStatusToProblema(status, ex), new HttpHeaders(), status, request);

    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> hand(EntidadeNaoEncontradaException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        return  handleExceptionInternal(ex, problemaMapper.httpStatusToProblema(status, ex), new HttpHeaders(), status, request);

    }

}