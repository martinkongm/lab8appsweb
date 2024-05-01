package com.martin.lab7maven.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_ventas";
    private static final String USER = "root";
    private static final String PASSWORD = "sasa";

    private static Connection conexion;

    private ConexionMysql() {}

    public static synchronized Connection obtenerConexion() {
        if (conexion == null) {
            try {
                // Cargar el driver de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establecer la conexión
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                // Manejar cualquier excepción
                e.printStackTrace();
            }
        }
        return conexion;
    }

    public static synchronized void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                // Manejar cualquier excepción
                e.printStackTrace();
            }
        }
    }
}
