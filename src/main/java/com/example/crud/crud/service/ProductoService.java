package com.example.crud.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.crud.crud.entity.Producto;
import com.example.crud.crud.repository.ProductoRepository;

@Service
public class ProductoService {
    // Inyección de dependencias

    @Autowired
    private ProductoRepository oProductoRepository;

    // GET
    public Producto get(Long id) {
        return oProductoRepository.findById(id).orElse(null);
    }

    // CREATE
    public Producto create(Producto oProducto) {
        oProducto.setId(null);
        return oProductoRepository.save(oProducto);
    }

    // GETALL
    public Page<Producto> getAll(Pageable pageable){
        return oProductoRepository.findAll(pageable);
    }
    // UPDATE
    public Producto update(Producto oProducto) {
        Producto oProductoExistente = oProductoRepository.findById(oProducto.getId()).orElse(null);
        oProductoExistente.setNombre(oProducto.getNombre());
        oProductoExistente.setCategoria(oProducto.getCategoria());
        oProductoExistente.setPrecio(oProducto.getPrecio());
        oProductoExistente.setStock(oProducto.getStock());
        oProductoExistente.setImagenUrl(oProducto.getImagenUrl());
        return oProductoRepository.save(oProductoExistente);
    }

    // DELETE
    public Long delete(Long id) {
        oProductoRepository.deleteById(id);
        return id;
    }
}
