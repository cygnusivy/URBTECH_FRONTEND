package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostRequest{

    private Long id;

    private String nomeUsuario;

    private String imgUrlUsuario;

    private String imgUrl;

    private String descricao;

    private Long qtdCurtidas;

    private List<ComentarioRequest> listaComentario;

}