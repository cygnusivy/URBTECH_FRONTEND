package com.urbtech.api.controller;

import com.urbtech.api.dto.UserRegistrationDto;
import com.urbtech.api.dto.request.UserRegistrationRequest;
import com.urbtech.domain.model.UserRegistrationModel;
import com.urbtech.domain.repository.UserRegistrationRepository;
import com.urbtech.domain.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UserRegistrationController {

    private UserRegistrationRepository userRegistrationRepository;
    private UserRegistrationService userRegistrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistrationModel cadastrar(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        return userRegistrationService.salvar(userRegistrationDto);
    }

    @GetMapping("retornoUsuario/{id}")
    public UserRegistrationRequest getUsuario(@PathVariable Long id){
        Optional<UserRegistrationModel> user = userRegistrationRepository.findById(id);
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();

        userRegistrationRequest.setDescricao(user.get().getDescricao());
        userRegistrationRequest.setEmail(user.get().getEmail());
        userRegistrationRequest.setId(user.get().getId());
        userRegistrationRequest.setName(user.get().getName());
        userRegistrationRequest.setLocalizacao(user.get().getLocalizacao());
        userRegistrationRequest.setSite(user.get().getSite());
        userRegistrationRequest.setNascimento(user.get().getNascimento());
        return userRegistrationRequest;
    }

    @PutMapping("atualizarUsuario/{id}")
    public UserRegistrationRequest atualizar(@Valid @PathVariable Long id, @RequestBody UserRegistrationRequest user){

        Optional<UserRegistrationModel> userModel = userRegistrationRepository.findById(id);

        userModel.get().setName(user.getName());
        userModel.get().setDescricao(user.getDescricao());
        userModel.get().setLocalizacao(user.getLocalizacao());
        userModel.get().setNascimento(user.getNascimento());
        userModel.get().setSite(user.getSite());

        System.out.println(user.getName());
        userRegistrationRepository.save(userModel.get());

        user.setName(userModel.get().getName());
        user.setDescricao(userModel.get().getDescricao());
        user.setLocalizacao(userModel.get().getLocalizacao());
        user.setNascimento(userModel.get().getNascimento());
        user.setSite(userModel.get().getSite());
        user.setEmail(userModel.get().getEmail());
        user.setId(userModel.get().getId());

        return user;
    }

    @DeleteMapping("deletarUsuario/{id}")
    public void removeConta(@PathVariable Long id){
        this.userRegistrationRepository.deleteById(id);
    }
}