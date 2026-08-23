package com.urbanclothes.main;

import com.urbanclothes.dao.CategoriaDAO;
import com.urbanclothes.dao.ProductoDAO;
import com.urbanclothes.model.Categoria;
import com.urbanclothes.model.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        System.out.println("=== PRUEBA DE CONEXION Y CRUD - URBAN CLOTHES ===");

        // 1. INSERTAR PRENDA (Ejemplo: Camiseta Till Death asignada a UNISEX - ID 3)
        System.out.println("\n--- 1. INSERTANDO NUEVA PRENDA ---");
        Producto nuevaPrenda = new Producto("Camiseta Till Death", "Camiseta oversize negra", 85000.0, "till_death.jpg", "UNISEX", true, 3);
        if (productoDAO.insertar(nuevaPrenda)) {
            System.out.println("-> Producto registrado correctamente.");
        }

        // 2. MOSTRAR CATÁLOGO ORGANIZADO POR CATEGORÍAS
        System.out.println("\n--- 2. MOSTRANDO CATÁLOGO POR CATEGORÍAS ---");
        List<Categoria> categorias = categoriaDAO.listar();

        for (Categoria cat : categorias) {
            System.out.println("\n[ CATEGORÍA: " + cat.getNombre() + " ]");
            List<Producto> prods = categoriaDAO.obtenerProductosPorCategoria(cat.getIdCategoria());
            
            if (prods.isEmpty()) {
                System.out.println("   (No hay prendas registradas en esta categoría)");
            } else {
                for (Producto p : prods) {
                    System.out.println("   - Prenda: " + p.getNombre() + " | Precio: $" + p.getPrecio());
                }
            }
        }
    }
}