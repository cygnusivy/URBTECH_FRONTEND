package com.urbtech.api.controller;

import com.urbtech.api.dto.LoginDto;
import com.urbtech.api.dto.request.LoginRequest;
import com.urbtech.api.mapper.LoginMapper;
import com.urbtech.domain.model.LoginModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.UserRepository;
import com.urbtech.domain.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("login")
public class LoginController {

    private LoginService loginService;

    private UserRepository userRepository;

    private LoginMapper loginMapper;

    @PostMapping("/loginUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginDto logar(@Valid @RequestBody LoginRequest loginRequest){

        LoginModel loginModel = loginService.logar(loginRequest.getEmail(), loginRequest.getSenha());
        LoginDto loginDto = loginMapper.loginModelToDto(loginModel);

        Optional<UserModel> userRegistrationModel = userRepository.findByEmail(loginModel.getEmail());
        loginDto.setIdUser(userRegistrationModel.get().getId());

        return loginDto;

    }

}