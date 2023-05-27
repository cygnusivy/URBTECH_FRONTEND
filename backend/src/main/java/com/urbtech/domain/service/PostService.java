package com.urbtech.domain.service;

import com.urbtech.api.dto.PostDto;
import com.urbtech.api.dto.request.PostRequest;
import com.urbtech.api.mapper.PostMapper;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.CurtidaModel;
import com.urbtech.domain.model.PostModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.CurtidaRepository;
import com.urbtech.domain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private CurtidaRepository curtidaRepository;

    private PostRepository postRepository;

    private UserService userService;

    private ComentarioService comentarioService;

    private PostMapper postMapper;

    @Transactional
    public PostDto postar(PostDto postDto){
        PostModel postModel = postMapper.dtoToEntity(postDto);

        if (this.userService.validaContaComIdUsuario(postDto.getIdUsuario()) == null){
            throw new BusinessException("Usuário não cadastrado.");
        }

        postModel.setQtdCurtidas(0L);
        this.postRepository.save(postModel);

        return postDto;
    }

    @Transactional
    public void curtir(CurtidaModel curtidaModel){
        this.userService.validaContaComIdUsuario(curtidaModel.getIdUsuarioCurtida());
        this.verificaExistenciaDoPostPeloId(curtidaModel.getIdPost());

        Optional<PostModel> postModel = this.postRepository.findById(curtidaModel.getIdPost());

        if (this.curtidaRepository.existsByIdPostAndIdUsuarioCurtida(curtidaModel.getIdPost(), curtidaModel.getIdUsuarioCurtida())){
            throw new BusinessException("Usuário já curtiu o post");
        }

        postModel.get().setQtdCurtidas(postModel.get().getQtdCurtidas() + 1);
        this.postRepository.save(postModel.get());
        this.curtidaRepository.save(curtidaModel);
    }

    public PostRequest selecionarPost(Long id){
        this.verificaExistenciaDoPostPeloId(id);
        Optional<PostModel> postModel = this.postRepository.findById(id);

        this.userService.validaContaComIdUsuario(postModel.get().getIdUsuario());
        UserModel userModel = this.userService.buscaUsuarioPeloId(postModel.get().getId());

        PostRequest postRequest = this.postMapper.entityToRequest(postModel.get());
        postRequest.setNomeUsuario(userModel.getNome());
        postRequest.setImgUrlUsuario(userModel.getImgUrl());
        postRequest.setListaComentario(this.comentarioService.comentarioRequestList(id));

        return postRequest;
    }

    public PostModel selecionaPost(Long id){
        this.verificaExistenciaDoPostPeloId(id);
        Optional<PostModel> postEntity = this.postRepository.findById(id);
        return postEntity.get();
    }

    public List<PostRequest> postRequestListPeloIdUsuario(Long idUsuario){

        UserModel userModel = this.userService.buscaUsuarioPeloId(idUsuario);

        List<PostModel> postModelList = this.postRepository.findAllByIdUsuario(idUsuario);
        List<PostRequest> postRequestList = new ArrayList<>();

        for (PostModel postModel : postModelList){

            PostRequest postRequest = this.postMapper.entityToRequest(postModel);
            postRequest.setNomeUsuario(userModel.getNome());
            postRequest.setImgUrlUsuario(userModel.getImgUrl());
            postRequest.setListaComentario(this.comentarioService.comentarioRequestList(postModel.getId()));

            postRequestList.add(postRequest);

        }

        return postRequestList;
    }

    public void deletarPost(Long id){
        this.verificaExistenciaDoPostPeloId(id);
        this.postRepository.deleteById(id);
    }

    public void verificaExistenciaDoPostPeloId(Long id){
        if (!this.postRepository.existsById(id)){
            throw new BusinessException("Post não encontrado");
        }
    }
}