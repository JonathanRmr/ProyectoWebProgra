<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Clientes</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h1>Gestión de Clientes</h1>
<div id="cliente-form">
    <form id="form-cliente">
        <input type="hidden" id="cliente-id">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" required>
        <label for="email">Email:</label>
        <input type="email" id="email" required>
        <button type="submit" id="submit-button">Agregar Cliente</button>
    </form>
</div>
<div id="cliente-list">
    <h2>Lista de Clientes</h2>
    <table>
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Email</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody id="clientes-tbody">
        <!-- Clientes se agregarán aquí dinámicamente -->
        </tbody>
    </table>
</div>
<script src="js/scripts.js"></script>
</body>
</html>
