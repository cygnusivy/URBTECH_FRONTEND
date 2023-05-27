package com.urbtech.domain.service;

import com.urbtech.api.dto.ComentarioDto;
import com.urbtech.api.dto.request.ComentarioRequest;
import com.urbtech.api.mapper.ComentarioMapper;
import com.urbtech.domain.model.ComentarioModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.ComentarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    private UserService userService;

    private ComentarioMapper comentarioMapper;

    @Transactional
    public ComentarioRequest comentar(ComentarioDto comentarioDto){
        this.userService.validaContaComIdUsuario(comentarioDto.getIdUsuarioComentario());

        UserModel userModelComentario = this.userService.buscaUsuarioPeloId(comentarioDto.getIdUsuarioComentario());

        ComentarioModel comentarioModel = comentarioMapper.dtoToModel(comentarioDto);
        comentarioModel.setHorarioPublicacao(LocalDateTime.now());

        this.comentarioRepository.save(comentarioModel);

        ComentarioRequest comentarioRequest = comentarioMapper.modelToRequest(comentarioModel);
        comentarioRequest.setNomeUsuarioComentario(userModelComentario.getNome());
        comentarioRequest.setImgUrlUsuarioComentario(userModelComentario.getImgUrl());

        return comentarioRequest;
    }

    public List<ComentarioRequest> comentarioRequestList(Long idPost){

        List<ComentarioModel> comentarioModelList = this.comentarioRepository.findAllByIdPost(idPost);
        List<ComentarioRequest> comentarioRequestList = new ArrayList<>();

        for (ComentarioModel comentarioModel : comentarioModelList){

            ComentarioRequest comentarioRequest = this.comentarioMapper.modelToRequest(comentarioModel);
            UserModel userComentario = this.userService.buscaUsuarioPeloId(comentarioRequest.getIdUsuarioComentario());

            comentarioRequest.setImgUrlUsuarioComentario(userComentario.getImgUrl());
            comentarioRequest.setNomeUsuarioComentario(userComentario.getNome());

            comentarioRequestList.add(comentarioRequest);
        }

        return comentarioRequestList;
    }

}