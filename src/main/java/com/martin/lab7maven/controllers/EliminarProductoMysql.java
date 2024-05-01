package com.martin.lab7maven.controllers;

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

@WebServlet("/eliminarmysql")
public class EliminarProductoMysql extends HttpServlet {

    ProductoDao productoDao = new ProductoRepositoryMySql();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("eliminarProductoMysql.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el ID del producto a eliminar
        String idProductoStr = request.getParameter("id");
        Integer idProducto = Integer.parseInt(idProductoStr);
        
        //Eliminar el producto de la base de datos
        productoDao.eliminar(idProducto);
        
        //Redirigir a la página de listar productos
        response.sendRedirect("listarmysql");
    }
}
