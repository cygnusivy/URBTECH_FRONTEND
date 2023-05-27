package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "postagem")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String imgUrl;

    @NotNull
    private Long idUsuario;

    private String descricao;

    private Long qtdCurtidas;

}