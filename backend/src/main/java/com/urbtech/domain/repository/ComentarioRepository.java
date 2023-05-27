package com.urbtech.domain.repository;

import com.urbtech.domain.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioModel, Long> {

    List<ComentarioModel> findAllByIdPost(Long idPost);
}