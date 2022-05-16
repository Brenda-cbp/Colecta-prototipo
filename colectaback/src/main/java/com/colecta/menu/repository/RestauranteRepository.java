package com.colecta.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colecta.menu.entities.Restaurante;

@Repository("restauranteRepository")
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
