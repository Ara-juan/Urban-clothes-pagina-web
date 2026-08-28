package com.americanoshh.catalogo.controller;

import com.americanoshh.catalogo.model.Producto;
import com.americanoshh.catalogo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Con esto podremos hacer peticiones
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Método GET: Obtener todos los productos (o solo los activos)
    @GetMapping
    public List<Producto> obtenerProductos(@RequestParam(required = false) Boolean soloActivos) {
        if (Boolean.TRUE.equals(soloActivos)) {
            return productoRepository.findByActivoTrue();
        }
        return productoRepository.findAll();
    }

    // Método POST: Crear o actualizar un producto bajo demanda
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}