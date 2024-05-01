package com.martin.lab7maven.controllers;

import com.martin.lab7maven.models.Producto;
import com.martin.lab7maven.models.ProductoDao;
import com.martin.lab7maven.models.ProductoRepositoryMongoDb;
import com.martin.lab7maven.models.ProductoRepositoryMySql;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrar")
public class RegistrarProducto extends HttpServlet {
    
    private ProductoDao productoDao = new ProductoRepositoryMongoDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("registrarProducto.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String database = (String) request.getParameter("database");
        
        Integer codigo = null;
        if (database.equals("mysql")) {
            productoDao = new ProductoRepositoryMySql();
        } else if(database.equals("mongo")) {
            productoDao = new ProductoRepositoryMongoDb();
            codigo = Integer.valueOf(request.getParameter("codigo"));
        }
        
        try {
            //Obtener los parámetros del formulario
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            //Crear un nuevo producto
            Producto producto = new Producto(codigo, nombre, precio, stock);
            
            //Registrar el producto en la base de datos
            productoDao.registrar(producto);
            
            //Redireccionar a la página de listado de productos
            response.sendRedirect("listar");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
