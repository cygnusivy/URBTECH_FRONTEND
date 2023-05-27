package com.urbtech.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComentarioDto {

    private Long id;

    private Long idPost;

    private Long idUsuarioComentario;

    private String comentario;

}
