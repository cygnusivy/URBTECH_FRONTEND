package com.urbtech.api.controller;

import com.urbtech.api.dto.UserDto;
import com.urbtech.api.dto.request.ImgPerfil;
import com.urbtech.api.dto.request.UserRequest;
import com.urbtech.api.mapper.UserMapper;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.model.UsuarioComunidadeModel;
import com.urbtech.domain.repository.UserRepository;
import com.urbtech.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("usuario")
public class UserController {

    private UserRepository userRepository;

    private UserService userService;

    private UserMapper userMapper;

    //private Logger LOGGER;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel cadastrar(@Valid @RequestBody UserDto userDto){

        //LOGGER.info("Início do método para cadastro de usuário.");
        return userService.salvar(userDto);
    }

    @PostMapping("entrarComunidade")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> entrarNaComunidade(@Valid @RequestBody UsuarioComunidadeModel usuarioComunidadeModel){
        this.userService.entrarEmComunidade(usuarioComunidadeModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("retornoUsuario/{id}")
    public UserRequest getUsuario(@PathVariable Long id){
        Optional<UserModel> user = Optional.ofNullable(this.userService.buscaUsuarioPeloId(id));
        UserRequest userRequest = userMapper.userModelToRequest(Optional.of(user.get()));
        return userRequest;
    }

    @GetMapping("retornaUrlFotoPerfil/{id}")
    public ImgPerfil getUrlFotoPerfil(@Valid @PathVariable Long id){
        UserModel userModel = this.userService.buscaUsuarioPeloId(id);
        ImgPerfil imgPerfil = new ImgPerfil();
        imgPerfil.setUrlFotoPerfil(userModel.getImgUrl());
        return imgPerfil;
    }

    @PutMapping("atualizarUsuario/{id}")
    public UserRequest atualizar(@Valid @PathVariable Long id, @RequestBody UserRequest user){

        Optional<UserModel> userModel = Optional.ofNullable(this.userService.buscaUsuarioPeloId(id));

        if (user.getImgUrl() == null){
            user.setImgUrl(userModel.get().getImgUrl());
        }

        Optional<UserModel> userModel1 = Optional.ofNullable(userMapper.userRequestToModel(user));

        userModel1.get().setEmail(userModel.get().getEmail());
        userModel1.get().setSenha(userModel.get().getSenha());
        userModel1.get().setId(userModel.get().getId());
        userRepository.save(userModel1.get());

        user = userMapper.userModelToRequest(Optional.of(userModel.get()));

        return user;
    }

    @DeleteMapping("deletarUsuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> removeConta(@PathVariable Long id){
        return this.userService.apagarConta(id);
    }

}