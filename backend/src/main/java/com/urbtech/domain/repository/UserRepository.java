package com.urbtech.domain.repository;

import com.urbtech.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    List<UserModel> findByName(String nome);
    Optional<UserModel> findByEmail(String email);

    boolean existsByEmail(String email);
}