package com.example.crud.crud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.crud.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Buscar por nombre
    List<Producto> findByNombre(String nombre);

    // Paginación
    Page<Producto> findAll(Pageable pageable);
}
