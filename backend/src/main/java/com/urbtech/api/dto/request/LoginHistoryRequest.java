package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoginHistoryRequest {

    private String email;
    private String password;
}
