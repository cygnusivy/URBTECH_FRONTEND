package com.urbtech.domain.repository;

import com.urbtech.domain.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

    List<PostModel> findAllByIdUsuario(Long idUsuario);
}