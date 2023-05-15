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
@NoArgsConstructor
@Entity
@Table(name = "login_history")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoginModel {
    
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.ClientId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 1)
    private String indLoginSucess;

    @NotNull
    private LocalDate loginDate;
}
