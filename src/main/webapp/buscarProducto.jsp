<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.martin.lab7maven.models.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Buscar Producto</title>
    </head>
    <body>
        <h2>Buscar Producto</h2>
        <form action="buscar" method="post">
            <label for="nombre">Nombre del Producto:</label>
            <input type="text" id="nombre" name="nombre">
            <label for="database">Seleccione la base de datos:</label>
            <select class="form-control" id="database" name="database">
                <option value="mysql" ${param.database == 'mysql' ? 'selected' : ''}>MySQL</option>
                <option value="mongo" ${param.database == 'mongo' ? 'selected' : ''}>MongoDB</option>
            </select>
            <button type="submit">Buscar</button>
        </form>

        <hr>

        <h3>Resultados de la Búsqueda</h3>
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
                <% List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                if (productos != null && !productos.isEmpty()) {
                    for (Producto producto : productos) {%>
                <tr>
                    <td><%= producto.codigo()%></td>
                    <td><%= producto.nombre()%></td>
                    <td><%= producto.precio()%></td>
                    <td><%= producto.stock()%></td>
                </tr>
                <%     }
            } else { %>
                <tr>
                    <td colspan="4">No se encontraron resultados</td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>


