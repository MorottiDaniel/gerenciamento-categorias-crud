package com.morotti.categorias.repository;

import com.morotti.categorias.entity.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasEntity, Long> {
}
