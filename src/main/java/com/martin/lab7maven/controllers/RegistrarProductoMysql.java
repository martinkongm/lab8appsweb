package com.martin.lab7maven.controllers;

import com.martin.lab7maven.models.Producto;
import com.martin.lab7maven.models.ProductoDao;
import com.martin.lab7maven.models.ProductoRepositoryMongoDb;
import com.martin.lab7maven.models.ProductoRepositoryMySql;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrarmysql")
public class RegistrarProductoMysql extends HttpServlet {
    
    private final ProductoDao productoDao = new ProductoRepositoryMySql();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registrarProductoMysql.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Obtener los parámetros del formulario
            //int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            //Crear un nuevo producto
            Producto producto = new Producto(null, nombre, precio, stock);
            
            //Registrar el producto en la base de datos
            productoDao.registrar(producto);
            
            //Redireccionar a la página de listado de productos
            response.sendRedirect("listarmysql");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
