package com.urbtech.domain.service;


import com.urbtech.api.dto.request.LoginHistoryRequest;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.LoginHistory;
import com.urbtech.domain.model.UserRegistrationModel;
import com.urbtech.domain.repository.LoginHistoryRepository;
import com.urbtech.domain.repository.UserRegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private LoginHistoryRepository loginHistoryRepository;
    private UserRegistrationRepository userRegistrationRepository;

    @Transactional
    public LoginHistory logar(String email, String password) {
        if (!userRegistrationRepository.existsByEmail(email)){
            LoginHistory loginHistory = new LoginHistory();
            loginHistory.setEmail(email);
            loginHistory.setLoginDate(LocalDate.now());
            loginHistory.setIndLoginSucess("N");
            loginHistoryRepository.save(loginHistory);
            throw new BusinessException("Email não cadastrado");
        }else{
            validaSenha(email, password);
            LoginHistory loginHistory = new LoginHistory();
            loginHistory.setLoginDate(LocalDate.now());
            loginHistory.setEmail(email);
            loginHistory.setIndLoginSucess("S");
            loginHistoryRepository.save(loginHistory);
            return  loginHistory;
        }
    }

    private void validaSenha(String email, String senha){
        Optional<UserRegistrationModel> userModel = userRegistrationRepository.findByEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(senha, userModel.get().getPassword())){
            throw new BusinessException("Senha inválida");
        }
    }

}
