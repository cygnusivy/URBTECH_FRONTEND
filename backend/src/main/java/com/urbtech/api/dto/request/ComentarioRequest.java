package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComentarioRequest {

    private Long id;

    private Long idPost;

    private Long idUsuarioComentario;

    private String nomeUsuarioComentario;

    private String imgUrlUsuarioComentario;

    private String comentario;

    private LocalDateTime horarioPublicacao;

}