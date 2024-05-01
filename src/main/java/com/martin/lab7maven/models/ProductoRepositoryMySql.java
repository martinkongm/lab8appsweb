package com.martin.lab7maven.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryMySql implements ProductoDao {

    @Override
    public void registrar(Producto producto) {
        Connection conexion = null;
        PreparedStatement statement = null;
        try {
            conexion = ConexionMysql.obtenerConexion();
            String query = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";
            statement = conexion.prepareStatement(query);
            //statement.setInt(1, producto.codigo());
            statement.setString(1, producto.nombre());
            statement.setDouble(2, producto.precio());
            statement.setInt(3, producto.stock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //ConexionMysql.cerrarConexion();
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = ConexionMysql.obtenerConexion();
            String query = "SELECT * FROM producto";
            statement = conexion.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getInt("stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //ConexionMysql.cerrarConexion();
        }
        return productos;
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = ConexionMysql.obtenerConexion();
            String query = "SELECT * FROM producto WHERE nombre LIKE ?";
            statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + nombre + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getInt("stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return productos;
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        Producto producto = null;
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = ConexionMysql.obtenerConexion();
            String query = "SELECT * FROM producto WHERE codigo = ?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                producto = new Producto(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return producto;
    }

    @Override
    public void eliminar(Integer id) {
        Connection conexion = null;
        PreparedStatement statement = null;
        try {
            conexion = ConexionMysql.obtenerConexion();
            String query = "DELETE FROM producto WHERE codigo = ?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

