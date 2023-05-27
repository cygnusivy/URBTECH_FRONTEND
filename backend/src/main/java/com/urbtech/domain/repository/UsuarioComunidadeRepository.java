package com.urbtech.domain.repository;

import com.urbtech.domain.model.UsuarioComunidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioComunidadeRepository extends JpaRepository<UsuarioComunidadeModel, Long> {

    Boolean existsByIdComunidadeAndIdUsuario(Long idComunidade, Long idUsuario);

    List<UsuarioComunidadeModel> findAllByIdComunidade(Long idComunidade);
}