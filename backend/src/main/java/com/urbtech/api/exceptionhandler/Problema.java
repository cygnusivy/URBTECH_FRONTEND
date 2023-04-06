package com.urbtech.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String descricao;

    private List<Field> filds;
    @AllArgsConstructor
    @Getter
    public static class Field {
        private String nome;
        private String mensagem;
    }
}