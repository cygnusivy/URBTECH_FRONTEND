package com.urbtech.domain.service;

import com.urbtech.api.dto.UserDto;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    @Transactional
    public UserModel salvar(UserDto userDto){

        boolean emailEmUso = userRepository.findByEmail(userDto.getEmail())
                .stream()
                .anyMatch(c -> !c.equals(userDto));

        if (emailEmUso){
            throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        validaSenha(userDto.getPassword(), userDto.getPasswordAgain());

        String senhaCriptografada1 = encoder.encode(userDto.getPassword());
        String senhaCriptografada2 = encoder.encode(userDto.getPasswordAgain());

        UserModel userModel = new UserModel();
        userModel.setName(userDto.getName());
        userModel.setEmail(userDto.getEmail());

        userModel.setPassword(senhaCriptografada1);
        userModel.setAccountCreationDate(LocalDate.now());

        return this.userRepository.save(userModel);
    }

    public Long validaContaComIdUsuario(Long id){
        if (!this.userRepository.existsById(id)){
            throw new BusinessException("Não existe um usuário cadastrado para ");
        }else{
            return id;
        }
    }
    public ResponseEntity<Void> apagarConta(Long id){
        if (validaContaComIdUsuario(id) != null){
            this.userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    private void validaSenha(String password, String passwordAgain){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!password.equals(passwordAgain)){
            throw new BusinessException("Senhas não são iguais. As senhas precisam ser iguais.");
        }
    }
}