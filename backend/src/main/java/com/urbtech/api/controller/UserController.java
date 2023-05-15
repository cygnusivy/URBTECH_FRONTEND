package com.urbtech.api.controller;

import com.urbtech.api.dto.UserDto;
import com.urbtech.api.dto.request.UserRequest;
import com.urbtech.api.mapper.UserMapper;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.UserRepository;
import com.urbtech.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    private UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel cadastrar(@Valid @RequestBody UserDto userDto){
        return userService.salvar(userDto);
    }

    @GetMapping("retornoUsuario/{id}")
    public UserRequest getUsuario(@PathVariable Long id){
        this.userService.validaContaComIdUsuario(id);
        Optional<UserModel> user = userRepository.findById(id);
        UserRequest userRequest = userMapper.userModelToRequest(Optional.of(user.get()));
        return userRequest;
    }

    @PutMapping("atualizarUsuario/{id}")
    public UserRequest atualizar(@Valid @PathVariable Long id, @RequestBody UserRequest user){

        this.userService.validaContaComIdUsuario(id);
        Optional<UserModel> userModel = this.userRepository.findById(id);
        Optional<UserModel> userModel1 = Optional.ofNullable(userMapper.userRequestToModel(user));

        userModel1.get().setEmail(userModel.get().getEmail());
        userModel1.get().setPassword(userModel.get().getPassword());
        userModel1.get().setId(userModel.get().getId());
        userRepository.save(userModel1.get());

        user = userMapper.userModelToRequest(Optional.of(userModel.get()));

        return user;
    }

    @DeleteMapping("deletarUsuario/{id}")
    public ResponseEntity<Void> removeConta(@PathVariable Long id){
        return this.userService.apagarConta(id);
    }
}