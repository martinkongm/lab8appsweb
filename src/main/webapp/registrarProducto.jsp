<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Producto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Registrar Producto</h2>
            <form action="/Lab7Maven/registrar" method="post">
                
                <label for="database">Seleccione la base de datos:</label>
                <select class="form-control" id="database" name="database">
                    <option value="mysql" ${param.database == 'mysql' ? 'selected' : ''}>MySQL</option>
                    <option value="mongo" ${param.database == 'mongo' ? 'selected' : ''}>MongoDB</option>
                </select>
                
                <div class="form-group">
                    <label for="codigo">Código:</label>
                    <input type="number" class="form-control" id="codigo" name="codigo" required>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="form-group">
                    <label for="precio">Precio:</label>
                    <input type="text" class="form-control" id="precio" name="precio" required>
                </div>
                <div class="form-group">
                    <label for="stock">Stock:</label>
                    <input type="number" class="form-control" id="stock" name="stock" required>
                </div>
                <button type="submit" class="btn btn-primary">Registrar Producto</button>
            </form>
        </div>
    </body>
</html>

