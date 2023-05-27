package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comentario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComentarioModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idPost;

    @NotNull
    private Long idUsuarioComentario;

    @Size(max = 100)
    private String comentario;

    private LocalDateTime horarioPublicacao;

}