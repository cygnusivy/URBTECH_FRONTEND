package com.urbtech.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "images")
public class ImagemPerfilModel {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    private Long idUsuario;

    private Blob img;

}