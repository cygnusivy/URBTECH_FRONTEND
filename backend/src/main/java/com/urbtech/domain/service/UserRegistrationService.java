package com.urbtech.domain.service;

import com.urbtech.api.dto.UserRegistrationDto;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.UserRegistrationModel;
import com.urbtech.domain.repository.UserRegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UserRegistrationService {

    private UserRegistrationRepository userRegistrationRepository;
    @Transactional
    public UserRegistrationModel salvar(UserRegistrationDto userRegistrationDto){

        boolean emailEmUso = userRegistrationRepository.findByEmail(userRegistrationDto.getEmail())
                .stream()
                .anyMatch(c -> !c.equals(userRegistrationDto));

        if (emailEmUso){
            throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        validaSenha(userRegistrationDto.getPassword(), userRegistrationDto.getPasswordAgain());

        String senhaCriptografada1 = encoder.encode(userRegistrationDto.getPassword());
        String senhaCriptografada2 = encoder.encode(userRegistrationDto.getPasswordAgain());

        UserRegistrationModel userRegistrationModel = new UserRegistrationModel();
        userRegistrationModel.setId(userRegistrationDto.getId());
        userRegistrationModel.setName(userRegistrationDto.getName());
        userRegistrationModel.setEmail(userRegistrationDto.getEmail());

        userRegistrationModel.setPassword(senhaCriptografada1);
        userRegistrationModel.setAccountCreationDate(LocalDate.now());

        return this.userRegistrationRepository.save(userRegistrationModel);
    }

    private void validaSenha(String password, String passwordAgain){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!password.equals(passwordAgain)){
            throw new BusinessException("Senhas não são iguais. As senhas precisam ser iguais.");
        }
    }
}