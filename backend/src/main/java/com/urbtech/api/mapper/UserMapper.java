package com.urbtech.api.mapper;

import com.urbtech.api.dto.request.UserRequest;
import com.urbtech.domain.model.UserModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserMapper {

    private ModelMapper modelMapper;

    public UserRequest userModelToRequest(Optional<UserModel> userModel){
        return modelMapper.map(userModel.get(), UserRequest.class);
    }

    public UserModel userRequestToModel(UserRequest userRequest){
        return modelMapper.map(userRequest, UserModel.class);
    }

}