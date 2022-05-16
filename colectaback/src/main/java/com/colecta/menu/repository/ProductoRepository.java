package com.colecta.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colecta.menu.entities.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
