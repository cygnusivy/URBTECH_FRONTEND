package com.urbtech.domain.model;

import com.urbtech.domain.validation.ValidationGroups;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "registro_login")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoginModel {

    @Id
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.EntityId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 1)
    private String indLoginSucesso;

    @NotNull
    @Size(max = 100)
    private String descricaoLogin;

    @NotNull
    private LocalDate loginDate;

}