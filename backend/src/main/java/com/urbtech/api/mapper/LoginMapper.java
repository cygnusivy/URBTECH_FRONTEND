package com.urbtech.api.mapper;

import com.urbtech.api.dto.LoginDto;
import com.urbtech.domain.model.LoginModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginMapper {

    private ModelMapper modelMapper;

    public LoginDto loginModelToDto(LoginModel loginModel){
        return modelMapper.map(loginModel, LoginDto.class);
    }

}