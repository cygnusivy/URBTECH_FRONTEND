package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {

    private Long id;
    private String name;
    private String email;

}