package com.urbtech.domain.service;


import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.LoginModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.LoginRepository;
import com.urbtech.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private LoginRepository loginRepository;
    private UserRepository userRepository;

    @Transactional
    public LoginModel logar(String email, String password) {
        if (!userRepository.existsByEmail(email)){
            LoginModel loginModel = new LoginModel();
            loginModel.setEmail(email);
            loginModel.setLoginDate(LocalDate.now());
            loginModel.setIndLoginSucesso("N");
            loginModel.setDescricaoLogin("Login não efetuado, email não cadastrado.");
            loginRepository.save(loginModel);
            throw new BusinessException("Email não cadastrado.");
        }else{
            validaSenha(email, password);
            LoginModel loginModel = new LoginModel();
            loginModel.setLoginDate(LocalDate.now());
            loginModel.setEmail(email);
            loginModel.setIndLoginSucesso("S");
            loginModel.setDescricaoLogin("Login realizado com sucesso.");
            loginRepository.save(loginModel);
            return loginModel;
        }
    }

    private void validaSenha(String email, String senha){
        Optional<UserModel> userModel = userRepository.findByEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(senha, userModel.get().getSenha())){
            throw new BusinessException("Senha inválida");
        }
    }

}