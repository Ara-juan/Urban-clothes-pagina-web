package com.urbanclothes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_urban_clothes";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres"; 

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // Cargar explícitamente el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("-> Conexión a PostgreSQL establecida correctamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("-> Error: No se encontró el driver JDBC en el classpath: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("-> Error al conectar a PostgreSQL: " + e.getMessage());
        }
        return conexion;
    }
}