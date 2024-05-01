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
            <form action="/Lab7Maven/listar" method="get">
                <label for="database">Seleccione la base de datos:</label>
                <select class="form-control" id="database" name="database">
                    <option value="mysql" ${param.database == 'mysql' ? 'selected' : ''}>MySQL</option>
                    <option value="mongo" ${param.database == 'mongo' ? 'selected' : ''}>MongoDB</option>
                </select>
                <input type="submit" value="Seleccionar">
            </form>

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
                    <% for (Producto producto : (List<Producto>) request.getAttribute("productos")) {%>
                    <tr>
                        <td><%= producto.codigo()%></td>
                        <td><%= producto.nombre()%></td>
                        <td><%= producto.precio()%></td>
                        <td><%= producto.stock()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
