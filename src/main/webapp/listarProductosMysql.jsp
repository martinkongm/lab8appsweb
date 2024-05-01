<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.martin.lab7maven.models.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
    <div class="container">
        <h2>Listado de Productos</h2>
        <a href="indexMysql.html">Regresar</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                <% for (Producto producto : (List<Producto>) request.getAttribute("productos")) { %>
                <tr>
                    <td><%= producto.codigo() %></td>
                    <td><%= producto.nombre() %></td>
                    <td><%= producto.precio() %></td>
                    <td><%= producto.stock() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
