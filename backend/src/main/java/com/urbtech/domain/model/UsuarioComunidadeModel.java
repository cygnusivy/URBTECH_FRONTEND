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
@Table(name = "usuario_comunidade")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioComunidadeModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idComunidade;

}