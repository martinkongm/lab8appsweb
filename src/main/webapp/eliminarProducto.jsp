<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Eliminar Producto</title>
    </head>
    <body>
        <h2>Eliminar Producto</h2>
        <form action="eliminar" method="post">
            <label for="id">ID del Producto a Eliminar:</label>
            <input type="text" id="id" name="id">
            <select class="form-control" id="database" name="database">
                <option value="mysql" ${param.database == 'mysql' ? 'selected' : ''}>MySQL</option>
                <option value="mongo" ${param.database == 'mongo' ? 'selected' : ''}>MongoDB</option>
            </select>
            <button type="submit">Eliminar</button>
        </form>
    </body>
</html>
