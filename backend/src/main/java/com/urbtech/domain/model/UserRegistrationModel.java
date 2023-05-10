package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "user_registration")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserRegistrationModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.ClientId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 2000)
    private String password;

    private String descricao;

    private String localizacao;

    private String site;

    private LocalDate nascimento;

    @Column(name = "account_creation_date")
    private LocalDate accountCreationDate;

    @Column(name = "account_deactivation_date")
    private LocalDate accountDeactivationDate;
}