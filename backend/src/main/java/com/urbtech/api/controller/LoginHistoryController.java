package com.urbtech.api.controller;

import com.urbtech.api.dto.LoginHistoryDto;
import com.urbtech.api.dto.request.LoginHistoryRequest;
import com.urbtech.domain.model.LoginHistory;
import com.urbtech.domain.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginHistoryController {

    private LoginService loginService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginHistoryDto logar(@Valid @RequestBody LoginHistoryRequest loginHistoryRequest){
        LoginHistory loginHistory = loginService.logar(loginHistoryRequest.getEmail(), loginHistoryRequest.getPassword());
        LoginHistoryDto loginHistoryDto = new LoginHistoryDto();
        loginHistoryDto.setLoginDate(loginHistory.getLoginDate());
        loginHistoryDto.setId(loginHistory.getId());loginHistoryDto.setIndLoginSucess(loginHistory.getIndLoginSucess());
        loginHistoryDto.setEmail(loginHistory.getEmail());
        loginHistoryDto.setIndLoginSucess(loginHistory.getIndLoginSucess());
        return loginHistoryDto;
    }

}
