package com.urbtech.api.controller;

import com.urbtech.api.dto.UserRegistrationDto;
import com.urbtech.domain.model.UserRegistrationModel;
import com.urbtech.domain.repository.UserRegistrationRepository;
import com.urbtech.domain.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/userRegistration")
public class UserRegistrationController {

    private UserRegistrationRepository userRegistrationRepository;
    private UserRegistrationService userRegistrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistrationModel cadastrar(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        return userRegistrationService.salvar(userRegistrationDto);
    }
}