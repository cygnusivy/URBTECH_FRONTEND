package com.urbtech.domain.repository;

import com.urbtech.domain.model.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationModel, Long> {

    List<UserRegistrationModel> findByName(String nome);
    Optional<UserRegistrationModel> findByEmail(String email);

    boolean existsByEmail(String email);
}