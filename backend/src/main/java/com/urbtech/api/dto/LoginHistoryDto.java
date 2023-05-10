package com.urbtech.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoginHistoryDto {

    private Long id;
    private String email;
    private String indLoginSucess;
    private LocalDate loginDate;
    private Long idUser;
}
