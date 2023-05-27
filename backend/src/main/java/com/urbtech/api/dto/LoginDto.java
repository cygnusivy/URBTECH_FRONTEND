package com.urbtech.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoginDto {

    private String email;

    private String indLoginSucesso;

    private LocalDate loginDate;

    private Long idUser;

}