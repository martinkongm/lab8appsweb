package com.martin.lab7maven.controllers;

import com.martin.lab7maven.models.Producto;
import com.martin.lab7maven.models.ProductoDao;
import com.martin.lab7maven.models.ProductoRepositoryMongoDb;
import com.martin.lab7maven.models.ProductoRepositoryMySql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class ListarProducto extends HttpServlet {

    ProductoDao productoDao;// = new ProductoRepositoryMongoDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String database = request.getParameter("database");
        List<Producto> productos = null;
        
        if (database == null || database.equals("mysql")) {
            productoDao = new ProductoRepositoryMySql();
            productos = productoDao.listar();
            request.setAttribute("productos", productos);
        } else if(database.equals("mongo")) {
            productoDao = new ProductoRepositoryMongoDb();
            productos = productoDao.listar();
            request.setAttribute("productos", productos);
        }
       
        request.setAttribute("productos", productos);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarProductos.jsp");
        dispatcher.forward(request, response);
        
        
    }
}
