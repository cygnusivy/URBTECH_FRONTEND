package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationRequest {

    private Long id;
    private String name;
    private String email;
    private String descricao;
    private String localizacao;
    private String site;
    private LocalDate nascimento;

}