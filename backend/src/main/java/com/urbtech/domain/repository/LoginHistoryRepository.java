package com.urbtech.domain.repository;

import com.urbtech.domain.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    boolean existsByEmail(String email);

    LoginHistory findByEmail(String email);
}
