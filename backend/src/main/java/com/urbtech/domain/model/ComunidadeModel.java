package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comunidade")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComunidadeModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomeComunidade;

    @NotNull
    private LocalDateTime dataCriacaoComunidade;

    private Long qtdUsuarios = 0L;

    private Long qtdLimiteUsuarios = 250L;

}