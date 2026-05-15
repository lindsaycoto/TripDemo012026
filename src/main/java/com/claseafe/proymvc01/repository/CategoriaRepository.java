package com.claseafe.proymvc01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.claseafe.proymvc01.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}