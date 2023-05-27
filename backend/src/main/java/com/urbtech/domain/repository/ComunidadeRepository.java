package com.urbtech.domain.repository;

import com.urbtech.domain.model.ComunidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadeRepository extends JpaRepository<ComunidadeModel, Long> {

    Boolean existsByNomeComunidade(String nomeComunidade);

}