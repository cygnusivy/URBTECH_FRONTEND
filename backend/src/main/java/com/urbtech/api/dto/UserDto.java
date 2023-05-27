package com.urbtech.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String nome;

    private String imgUrl;

    private String email;

    private String senha;

    private String senha2;

}