<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.martin.lab7maven.models.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Obtener Producto por ID</title>
    </head>
    <body>
        <h2>Obtener Producto por ID</h2>
        <form action="buscarPorId" method="post">
            <label for="id">ID del Producto:</label>
            <input type="text" id="id" name="id">
            <label for="database">Seleccione la base de datos:</label>
            <select class="form-control" id="database" name="database">
                <option value="mysql" ${param.database == 'mysql' ? 'selected' : ''}>MySQL</option>
                <option value="mongo" ${param.database == 'mongo' ? 'selected' : ''}>MongoDB</option>
            </select>
            <button type="submit">Buscar</button>
        </form>

        <hr>

        <h3>Resultado de la Búsqueda</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                <% Producto producto = (Producto) request.getAttribute("producto");
                if (producto != null) {%>
                <tr>
                    <td><%= producto.codigo()%></td>
                    <td><%= producto.nombre()%></td>
                    <td><%= producto.precio()%></td>
                    <td><%= producto.stock()%></td>
                </tr>
                <% } else { %>
                <tr>
                    <td colspan="4">No se encontró ningún producto con el ID proporcionado</td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>

