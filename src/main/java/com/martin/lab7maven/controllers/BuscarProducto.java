package com.martin.lab7maven.controllers;

import com.martin.lab7maven.models.Producto;
import com.martin.lab7maven.models.ProductoDao;
import com.martin.lab7maven.models.ProductoRepositoryMongoDb;
import com.martin.lab7maven.models.ProductoRepositoryMySql;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscar")
public class BuscarProducto extends HttpServlet {
    
    ProductoDao productoDao = new ProductoRepositoryMongoDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("buscarProducto.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String database = (String) request.getParameter("database");

        if (database.equals("mysql")) {
            productoDao = new ProductoRepositoryMySql();
        } else if(database.equals("mongo")) {
            productoDao = new ProductoRepositoryMongoDb();
        }
        
        // Obtiene el nombre del producto ingresado por el usuario
        String nombreProducto = request.getParameter("nombre");
        
        // Realiza la búsqueda de productos por nombre en la base de datos
        List<Producto> productos = productoDao.buscarPorNombre(nombreProducto);
        
        // Guarda los resultados de la búsqueda en el request para mostrarlos en la página JSP
        request.setAttribute("productos", productos);
        
        // Envía la solicitud y los resultados de la búsqueda a la página JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProducto.jsp");
        dispatcher.forward(request, response);
    }
}
