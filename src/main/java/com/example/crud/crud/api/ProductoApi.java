package com.example.crud.crud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.crud.entity.Producto;
import com.example.crud.crud.service.ProductoService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ProductoApi {
    @Autowired
    private ProductoService oProductoService;

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Long id) {
        return ResponseEntity.ok(oProductoService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<Producto>> getAll(Pageable pageable){
        return  ResponseEntity.ok(oProductoService.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto oProducto){
        return ResponseEntity.ok(oProductoService.create(oProducto));
    }

    @PutMapping
    public ResponseEntity<Producto> update(@RequestBody Producto oProducto){
        return ResponseEntity.ok(oProductoService.update(oProducto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return ResponseEntity.ok(oProductoService.delete(id));
    }
}

