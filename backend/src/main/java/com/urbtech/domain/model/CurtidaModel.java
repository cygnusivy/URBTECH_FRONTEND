package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "curtida")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CurtidaModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idPost;

    @NotNull
    private Long idUsuarioCurtida;

}