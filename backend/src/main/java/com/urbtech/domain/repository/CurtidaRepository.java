package com.urbtech.domain.repository;

import com.urbtech.domain.model.CurtidaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<CurtidaModel, Long> {

    Boolean existsByIdPostAndIdUsuarioCurtida(Long idPost, Long idUsuarioCutida);
}
