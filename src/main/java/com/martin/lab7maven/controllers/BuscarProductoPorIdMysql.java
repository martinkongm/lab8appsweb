/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.martin.lab7maven.controllers;

import com.martin.lab7maven.models.Producto;
import com.martin.lab7maven.models.ProductoDao;
import com.martin.lab7maven.models.ProductoRepositoryMongoDb;
import com.martin.lab7maven.models.ProductoRepositoryMySql;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarPorIdmysql")
public class BuscarProductoPorIdMysql extends HttpServlet {
    
    ProductoDao productoDao = new ProductoRepositoryMySql();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("buscarPorId.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el ID del producto ingresado por el usuario
        String idProductoStr = request.getParameter("id");        
        //Hacer la búsqueda del producto por ID en la base de datos
        Producto producto = productoDao.obtenerPorId(Integer.parseInt(idProductoStr));
        
        //Guardar el resultado de la búsqueda en el request para mostrarlo en la página JSP
        request.setAttribute("producto", producto);
        
        //Hacer un forward a la página JSP con los objetos request y response
        RequestDispatcher dispatcher = request.getRequestDispatcher("buscarPorId.jsp");
        dispatcher.forward(request, response);
    }
}
