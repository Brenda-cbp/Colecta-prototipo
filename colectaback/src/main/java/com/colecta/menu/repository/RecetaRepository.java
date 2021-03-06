package com.colecta.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colecta.menu.entities.Receta;

@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta,Long> {

}
