package com.urbtech.domain.service;

import com.urbtech.api.dto.UserDto;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.ComunidadeModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.model.UsuarioComunidadeModel;
import com.urbtech.domain.repository.ComunidadeRepository;
import com.urbtech.domain.repository.UserRepository;
import com.urbtech.domain.repository.UsuarioComunidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    private UsuarioComunidadeRepository usuarioComunidadeRepository;

    private ComunidadeRepository comunidadeRepository;

    @Transactional
    public UserModel salvar(UserDto userDto){

        //LOGGUER.info("Verificando existência de usuário cadastrado para o email informado.");
        boolean emailEmUso = userRepository.findByEmail(userDto.getEmail())
                .stream()
                .anyMatch(c -> !c.equals(userDto));

        if (emailEmUso){
            //LOGGUER.info("Não foi possível realizar o cadastro pois já existe um usuário cadastrado com o email informado.");
            throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        validaSenha(userDto.getSenha(), userDto.getSenha2());

        String senhaCriptografada1 = encoder.encode(userDto.getSenha());

        UserModel userModel = new UserModel();
        userModel.setNome(userDto.getNome());
        userModel.setEmail(userDto.getEmail());

        userModel.setSenha(senhaCriptografada1);
        userModel.setDataAberturaConta(LocalDate.now());
        userModel.setImgUrl("https://res.cloudinary.com/dfgyr0fi7/image/upload/v1684527579/pjwp0vnnz4yecnoplab3.webp");

        this.userRepository.save(userModel);


        Optional<ComunidadeModel> comunidadeModel = this.comunidadeRepository.findById(1L);
        UsuarioComunidadeModel usuarioComunidadeModel = new UsuarioComunidadeModel();
        usuarioComunidadeModel.setIdComunidade(comunidadeModel.get().getId());
        usuarioComunidadeModel.setIdUsuario(userModel.getId());
        usuarioComunidadeRepository.save(usuarioComunidadeModel);

        return  userModel;
    }

    @Transactional
    public void entrarEmComunidade (UsuarioComunidadeModel usuarioComunidadeModel){
        this.validaExistenciaDaComunidade(usuarioComunidadeModel.getIdComunidade());
        this.validaContaComIdUsuario(usuarioComunidadeModel.getIdUsuario());

        Optional<ComunidadeModel> comunidadeModel = this.comunidadeRepository.findById(usuarioComunidadeModel.getIdComunidade());

        if (this.usuarioComunidadeRepository.existsByIdComunidadeAndIdUsuario(usuarioComunidadeModel.getIdComunidade(), usuarioComunidadeModel.getIdUsuario())){
            throw new BusinessException("Usuário já faz parte na comunidade");
        }

        if (comunidadeModel.get().getQtdUsuarios() < comunidadeModel.get().getQtdLimiteUsuarios()){
            this.usuarioComunidadeRepository.save(usuarioComunidadeModel);
            comunidadeModel.get().setQtdUsuarios(comunidadeModel.get().getQtdUsuarios() + 1);
        }else {
            throw new BusinessException("Limite de usuários atingido para a comunidade");
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

    public UserModel buscaUsuarioPeloId(Long id){
        Optional<UserModel> userModel = this.userRepository.findById(this.validaContaComIdUsuario(id));
        return userModel.get();
    }

    public Long validaContaComIdUsuario(Long id){
        if (!this.userRepository.existsById(id)){
            throw new BusinessException("Não existe um usuário cadastrado");
        }else{
            return id;
        }
    }

    public void validaExistenciaDaComunidade(Long id){
        if (!this.comunidadeRepository.existsById(id)){
            throw new BusinessException("Comunidade não existe.");
        }
    }

    private void validaSenha(String password, String passwordAgain){
        if (!password.equals(passwordAgain)){
            throw new BusinessException("Senhas não são iguais. As senhas precisam ser iguais.");
        }
    }

}