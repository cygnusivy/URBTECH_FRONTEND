package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private String descricao;

    private String localizacao;

    private String site;

    private LocalDate nascimento;

}