<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Producto</title>
</head>
<body>
    <h2>Eliminar Producto</h2>
    <form action="eliminarmysql" method="post">
        <label for="id">ID del Producto a Eliminar en Mysql:</label>
        <input type="text" id="id" name="id">
        <button type="submit">Eliminar</button>
    </form>
</body>
</html>
