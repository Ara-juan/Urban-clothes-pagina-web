package com.urbanclothes.dao;

import com.urbanclothes.config.ConexionBD;
import com.urbanclothes.model.Categoria;
import com.urbanclothes.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // Listar todas las categorías disponibles
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }

    // Obtener los productos asignados a una categoría específica
    public List<Producto> obtenerProductosPorCategoria(int idCategoria) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE id_categoria = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto p = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getString("imagen"),
                        rs.getString("genero"),
                        rs.getBoolean("activo"),
                        rs.getInt("id_categoria") 
                    );
                    productos.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar productos por categoría: " + e.getMessage());
        }
        return productos;
    }
}